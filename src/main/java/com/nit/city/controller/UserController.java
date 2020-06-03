package com.nit.city.controller;

import com.nit.city.fastdfs.UploadService;
import com.nit.city.bean.*;
import com.nit.city.service.*;
import com.nit.city.util.JsonToString;
import com.nit.city.util.Md5Util;
import com.nit.city.util.PythonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户业务层
 * 1.用户登录，注册，注销
 * 2.ajax验证管理员名与邮箱是否可用
 * 3.用户上传与查看图片
 *
 * @author lyc
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private PositionService positionService;

    @Autowired
    private CoordinateService coordinateService;

    @Autowired
    private UserService userService;

    @Autowired
    private UploadService uploadService;

    /**
     * 查询当前用户上传的所有照片
     *
     * @param session 获取当前用户信息
     * @return 返回所有当前用户上传的图片
     */
    @RequestMapping("/getUserImage")
    @ResponseBody
    public List<Image> getUserImage(HttpSession session) {
        // 从session中获取当前用户信息
        User user = (User) session.getAttribute("user");
        Integer userId = user.getUserId();
        //查询该用户上传的所有照片
        List<Image> userImages = userService.getUserImage(userId);
        return userImages;
    }

    /**
     * 用户上传图片
     *
     * @param file    前端传进的图片
     * @param session 获取用户信息
     * @return 成功跳转至查看所有自己上传图片页面，失败依旧在本页面
     */
    @RequestMapping("/uploadImage")
    public String uploadImage(String imageName,String imageDescription, MultipartFile file, HttpSession session, String latitude, String longitude
            , Integer province, Integer city, Integer district) {
        // 封装image类
        Image image = new Image();
        image.setImageName(imageName);
        image.setImageDescription(imageDescription);

        String url = null;
        try {
            // 利用fastDFS存入服务器中并返回访问url
            url = uploadService.saveFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 图片url存入image对象
        image.setImageUrl(url);
        // 放入python中识别该图片状态
        String jsonUrl = PythonUtil.httpUrlConnectionPost(url);
        // 返回图片状态码
        String stringResult = JsonToString.getJsonToString(jsonUrl);
        int intResult = Integer.valueOf(stringResult);
        // 查询输入坐标数据库是否存在
        Coordinate coordinate = coordinateService.getCoordinate(latitude, longitude);
        Integer coordinateId = null;
        if (coordinate != null) {
            // 已存在则获取coordinateId
            coordinateId = coordinate.getCoordinateId();
        } else {
            // 不存在则插入并返回coordinateId
            int result = coordinateService.uploadCoordinate(latitude, longitude);
            if (result != 0) {
                coordinate = coordinateService.getCoordinate(latitude, longitude);
                coordinateId = coordinate.getCoordinateId();
            }
        }
        // 将coordinateId存入image对象
        image.setCoordinateId(coordinateId);
        // 从session中获取当前用户信息
        User user = (User) session.getAttribute("user");
        Integer userId = user.getUserId();
        image.setUserId(userId);
        // 图片已被识别标记为2
        image.setStatus("2");
        // 图片识别的
        image.setResultId(intResult);
        // 该方法上传的图片均标记为用户上传
        image.setSource("用户");

        // 查询数据库中是否有对应的position
        Position positionByAllInfo = positionService.getPositionByAllInfo(province, city, district);
        Integer positionId;
        if (positionByAllInfo != null) {
            // 查询到数据库有对应城市
            positionId = positionByAllInfo.getPositionId();
        } else {
            // 未查到对应城市数据，插入该城市并返回positionId
            Position position = new Position();
            position.setProvinceId(province);
            position.setCityId(city);
            position.setDistrictId(district);
            positionService.uploadPosition(position);
            Position positionByAllInfoAfterInsert = positionService.getPositionByAllInfo(province, city, district);
            // 查询到数据库有对应城市
            positionId = positionByAllInfoAfterInsert.getPositionId();
        }
        image.setPositionId(positionId);
        // 注册时记录系统时间
        Date date = new Date();
        image.setImageTime(date);

        // 图片识别后,不为无积水时，系统自动给地图发送消息
        if(intResult!=1){
            Message message = new Message();
            message.setMessageName("系统上传");
            message.setMessageDescription("系统上传");
            message.setCoordinateId(coordinateId);
            message.setPositionId(positionId);
            message.setCreateTime(date);
            message.setCreator(user.getUserName());
            switch (intResult){
                case 2:
                    message.setResult("内涝");
                    break;
                case 3:
                    message.setResult("积水");
                    break;
                case 4:
                    message.setResult("冰雪");
                    break;
                default:
                    System.out.println("错误");
            }
            int uploadMessage = userService.uploadMessage(message);
            if(uploadMessage==0){
                System.out.println("发布消息失败");
            }else {
                System.out.println("发布消息成功");
            }
        }

        // 将整体image信息存入数据库
        int uploadImage = userService.uploadImage(image);
        if (uploadImage == 1) {
            // 成功则跳转至查看图片界面
            return "user/image";
        } else {
            // 失败则依旧在本界面
            return "user/uploadImage";
        }
    }

    /**
     * 检查email是否可用
     *
     * @param email    前端传进的email
     * @param response http response
     */
    @RequestMapping("/checkEmail")
    @ResponseBody
    public void checkEmail(@RequestParam("email") String email, HttpServletResponse
            response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 检查email数据库是否有重复
        email+=".com";
        User user = userService.checkEmail(email);
        if (user == null) {
            out.print("1");
        } else {
            out.print("2");
        }
        out.flush();
        out.close();
    }

    /**
     * 检查用户名是否可用
     *
     * @param userName 前端传进的用户名
     * @param response http response
     */
    @RequestMapping("/checkUserName")
    @ResponseBody
    public void checkUserName(@RequestParam("userName") String userName, HttpServletResponse
            response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 检查用户名数据库是否有重复
        User user = userService.checkUserName(userName);
        if (user == null) {
            out.print("1");
        } else {
            out.print("2");
        }
        out.flush();
        out.close();
    }

    /**
     * 用户注册功能
     *
     * @param user 用户类信息
     * @param file 头像信息
     * @return 成功跳转至用户登录页面，失败依旧在本页面
     */
    @RequestMapping("/register")
    public String register(User user, MultipartFile file,Map<String, Object> map) {
        // 用户密码MD5加密
        String password = user.getPassword();
        String code = Md5Util.code(password);
        user.setPassword(code);
        System.out.println(code);
        // 上传用户头像
        String url = null;
        try {
            url = uploadService.saveFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setAvatar(url);
        // 注册时记录系统时间
        Date date = new Date();
        user.setCreateTime(date);
        // 激活功能未做，目前默认激活
        user.setFlag("1");
        String email = user.getEmail();
        email+=".com";
        user.setEmail(email);
        // 注册成功返回1
        int registerBack = userService.register(user);
        if (registerBack == 1) {
            return "user/login";
        } else {
            map.put("msg", "注册失败");
            return "user/register";
        }
    }

    /**
     * 用户注销功能
     *
     * @param request http request
     * @return 返回主页面
     */
    @RequestMapping("/quitUser")
    public String quitUser(HttpServletRequest request) {
        // 获取当前session
        HttpSession session = request.getSession();
        // 移除user
        session.removeAttribute("user");
        return "index";
    }

    /**
     * 登录功能
     *
     * @param userName 用户名
     * @param password 密码
     * @return 返回loginUser，若不为空则登录成功
     */
    @RequestMapping("/login")
    public String login(String userName, String password, HttpServletRequest request, Map<String, Object> map) {
        // 用户密码MD5加密匹配
        password = Md5Util.code(password);
        System.out.println(password);
        HttpSession session = request.getSession(true);
        User loginUser = userService.login(userName, password);
        if (loginUser != null) {
            session.setAttribute("user", loginUser);
            return "user/index";
        } else {
            map.put("msg", "用户名密码错误");
            return "user/login";
        }
    }

    @RequestMapping("/toImage")
    public String toImage() {
        return "user/image";
    }

    @RequestMapping("/toUploadImage")
    public String toUploadImage() {
        return "user/uploadImage";
    }

    @RequestMapping("/toIndex")
    public String toUserIndex() {
        return "user/index";
    }

    @RequestMapping("/toLogin")
    public String userLogin() {
        return "user/login";
    }

    @RequestMapping("/toRegister")
    public String userRegister() {
        return "user/register";
    }
}
