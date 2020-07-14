package com.nit.city.controller;

import com.alibaba.fastjson.JSONObject;
import com.nit.city.fastdfs.UploadService;
import com.nit.city.bean.*;
import com.nit.city.service.*;
import com.nit.city.util.CityUtil;
import com.nit.city.util.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
 * 管理员业务层
 * 1.管理员登录，注册，注销
 * 2.ajax验证管理员名与邮箱是否可用
 * 3.获取所有用户信息
 * 4.获取所有用户上传图片信息
 * 5.上传和查询消息信息
 * 6.上传和查询摄像头信息
 *
 * @author lyc
 */
@Controller
@Slf4j
@RequestMapping("manager")
public class ManagerController {

    @Autowired
    private PositionService positionService;

    @Autowired
    private CoordinateService coordinateService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserService userService;

    @Autowired
    private ImageSevice imageSevice;

    @Autowired
    private UploadService uploadService;

    /*
    更新模块
     */

    /**
     * 根据摄像头id更新摄像头
     *
     * @param cameraId 消息id
     */
    @PostMapping("/updateCamera")
    public String updateCamera(@RequestParam("modal_cameraName") String cameraName, @RequestParam("modal_cameraId") Integer cameraId
            , HttpServletRequest request) {
        Camera camera = new Camera();
        camera.setCameraId(cameraId);
        camera.setCameraName(cameraName);
        int flag = managerService.updateCamera(camera);
        HttpSession session = request.getSession(true);
        if (flag == 0) {
            session.setAttribute("status", "修改失败");
        }else {
            session.setAttribute("status", "修改成功");
        }
        return "redirect:/manager/toMessage";
    }

    /**
     * 根据图片id更新图片
     *
     * @param result 消息id
     */
    @PostMapping("/updateImage")
    public String updateImage(@RequestParam("modal_result") Integer result, @RequestParam("modal_imageId") Integer imageId
            , HttpServletRequest request) {
        Image image = new Image();
        image.setImageId(imageId);
        image.setResultId(result);
        image.setImageDescription("人工修改");
        // 注册时记录系统时间
        Date date = new Date();
        image.setImageTime(date);
        int flag = imageSevice.updateImage(image);
        HttpSession session = request.getSession(true);
        if (flag == 0) {
            session.setAttribute("status", "修改失败");
        }else {
            session.setAttribute("status", "修改成功");
        }
        return "redirect:/manager/toMessage";
    }

    /**
     * 根据消息id更新消息
     *
     * @param result 消息id
     */
    @PostMapping("/updateMessage")
    public String updateMessage(@RequestParam("modal_result") String result, @RequestParam("modal_messageId") Integer messageId
            , HttpServletRequest request) {
        Message message = new Message();
        message.setMessageId(messageId);
        message.setResult(result);
        message.setMessageDescription("人工修改");
        // 注册时记录系统时间
        Date date = new Date();
        message.setCreateTime(date);
        int flag = managerService.updateMessage(message);
        HttpSession session = request.getSession(true);
        if (flag == 0) {
            session.setAttribute("status", "修改失败");
        }else {
            session.setAttribute("status", "修改成功");
        }
        return "redirect:/manager/toMessage";
    }

    /*
    删除模块
     */

    /**
     * 根据位置id删除位置
     *
     * @param positionId 位置id
     */
    @GetMapping("/deletePosition")
    @ResponseBody
    public void deletePosition(@RequestParam("positionId") Integer positionId) {
        positionService.deletePosition(positionId);
    }

    /**
     * 根据图片id删除图片
     *
     * @param imageId 消息id
     */
    @GetMapping("/deleteImage")
    @ResponseBody
    public void deleteImage(@RequestParam("imageId") Integer imageId) {
        imageSevice.deleteImage(imageId);
    }

    /**
     * 根据消息id删除消息
     *
     * @param messageId 消息id
     */
    @GetMapping("/deleteMessage")
    @ResponseBody
    public void deleteMessage(@RequestParam("messageId") Integer messageId) {
        managerService.deleteMessage(messageId);
    }

    /**
     * 根据摄像头id删除摄像头
     *
     * @param cameraId 摄像头id
     */
    @GetMapping("/deleteCamera")
    @ResponseBody
    public void deleteCamera(@RequestParam("cameraId") Integer cameraId) {
        managerService.deleteCamera(cameraId);
    }

    /**
     * 根据用户id删除用户
     *
     * @param userId 用户id
     */
    @GetMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(@RequestParam("userId") Integer userId) {
        managerService.deleteUser(userId);
    }

    /*
    查询模块
     */

    /**
     * 查询所有摄像头上传图片
     *
     * @return 返回所有摄像头上传图片
     */
    @GetMapping("/getAllPosition")
    @ResponseBody
    public List<Position> getAllPosition() {
        return positionService.getAllPosition();
    }

    /**
     * 获取所有摄像头
     *
     * @return 返回所有摄像头信息
     */
    @GetMapping("/getAllCamera")
    @ResponseBody
    public List<Camera> getAllCamera() {
        return managerService.getAllCamera();
    }

    /**
     * 查询所有摄像头上传图片
     *
     * @return 返回所有摄像头上传图片
     */
    @GetMapping("/getAllCameraImage")
    @ResponseBody
    public List<Image> getAllCameraImage() {
        String source = "摄像头";
        return imageSevice.getAllSourceImage(source);
    }

    /**
     * 查询所有用户上传图片
     *
     * @return 返回所有用户上传图片
     */
    @GetMapping("/getAllUserImage")
    @ResponseBody
    public List<Image> getAllUserImage() {
        // 参数为查询条件source
        return imageSevice.getAllSourceImage("用户");
    }


    /**
     * 查询所有消息
     *
     * @return 返回查询到的所有消息
     */
    @GetMapping("/getDangerMessage")
    @ResponseBody
    public List<Message> getDangerMessage() {
        return managerService.getDangerMessage();
    }

    /**
     * 查询所有消息
     *
     * @return 返回查询到的所有消息
     */
    @GetMapping("/getAllMessage")
    @ResponseBody
    public List<Message> getAllMessage() {
        return managerService.getAllMessage();
    }

    /**
     * 查询所有用户信息
     *
     * @return 返回所有用户信息
     */
    @GetMapping("/getAllUser")
    @ResponseBody
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    /*
    上传模块
     */

    /**
     * 上传摄像头信息
     *
     * @return 成功跳转至查看所有摄像头页面，失败依旧在本页面
     */
    @PostMapping("/uploadCamera")
    public String uploadCamera(String cameraName, Integer province, Integer city, Integer district) {

        // 封装camera类
        Camera camera = new Camera();
        camera.setCameraName(cameraName);

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
        camera.setPositionId(positionId);

        // 查询输入坐标数据库是否存在
        String latitude = null;
        String longitude = null;

        // 读取选择的省市县信息
        Position positionByPositionId = positionService.getOtherInfoByPositionId(positionId);
        Province provinceBack = positionByPositionId.getProvince();
        String provinceName = provinceBack.getProvince();
        City cityBack = positionByPositionId.getCity();
        String cityName = cityBack.getCity();
        District districtBack = positionByPositionId.getDistrict();
        String districtName = districtBack.getDistrict();

        // 通过百度地图api搜索该地的坐标位置
        String coordinateApi = CityUtil.httpUrlConnectionPost(provinceName + cityName + districtName + cameraName);
        coordinateApi = coordinateApi.substring(27);
        coordinateApi = coordinateApi.substring(0, coordinateApi.length() - 1);
        JSONObject json = JSONObject.parseObject(coordinateApi);

        // 搜索到管理员输入的街道信息
        if (json.get("status").toString().equals("0")) {
            latitude = json.getJSONObject("result").getJSONObject("location").getString("lng");
            longitude = json.getJSONObject("result").getJSONObject("location").getString("lat");
        } else {
            log.info("未找到相匹配的经纬度！");
            // 没有搜索到管理员输入的街道信息，填入省市县坐标
            coordinateApi = CityUtil.httpUrlConnectionPost(provinceName + cityName + districtName);
            coordinateApi = coordinateApi.substring(27);
            coordinateApi = coordinateApi.substring(0, coordinateApi.length() - 1);
            json = JSONObject.parseObject(coordinateApi);
            if (json.get("status").toString().equals("0")) {
                latitude = json.getJSONObject("result").getJSONObject("location").getString("lng");
                longitude = json.getJSONObject("result").getJSONObject("location").getString("lat");
            } else {
                log.info("程序错误!");
            }
        }

        // 坐标长度过长后面则省略
//        if(latitude.length()>12){
//            latitude = latitude.substring(0,12);
//        }
//        if(longitude.length()>12){
//            longitude = longitude.substring(0,12);
//        }
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
        camera.setCoordinateId(coordinateId);

        int uploadBack = managerService.uploadCamera(camera);
        if (uploadBack == 1) {
            return "redirect:/manager/toCamera";
        } else {
            return "manager/uploadCamera";
        }
    }

    /**
     * 管理员上传消息
     *
     * @return 成功跳转至查看所有信息页面，失败依旧在本页面
     */
    @PostMapping("/uploadMessage")
    public String uploadMessage(String messageName, String messageDescription, String result, String latitude,
                                String longitude, Integer province, Integer city, Integer district) {
        // 封装message类
        Message message = new Message();
        message.setMessageName(messageName);
        message.setMessageDescription(messageDescription);
        message.setResult(result);

        // 查询输入坐标数据库是否存在
        Coordinate coordinate = coordinateService.getCoordinate(latitude, longitude);
        Integer coordinateId = null;
        if (coordinate != null) {
            // 已存在则获取coordinateId
            coordinateId = coordinate.getCoordinateId();
        } else {
            // 不存在则插入并返回coordinateId
            int backResult = coordinateService.uploadCoordinate(latitude, longitude);
            if (backResult != 0) {
                coordinate = coordinateService.getCoordinate(latitude, longitude);
                coordinateId = coordinate.getCoordinateId();
            }
        }
        message.setCoordinateId(coordinateId);
        // 注册时记录系统时间
        Date date = new Date();
        message.setCreateTime(date);
        // 查询数据库中是否有对应的position
        Position positionByAllInfo = positionService.getPositionByAllInfo(province, city, district);
        if (positionByAllInfo != null) {
            // 查询到数据库有对应城市
            Integer positionId = positionByAllInfo.getPositionId();
            message.setPositionId(positionId);
        } else {
            // 未查到对应城市数据，插入该城市并返回positionId
            Position position = new Position();
            position.setProvinceId(province);
            position.setCityId(city);
            position.setDistrictId(district);
            positionService.uploadPosition(position);
            Position positionByAllInfoAfterInsert = positionService.getPositionByAllInfo(province, city, district);
            // 查询到数据库有对应城市
            Integer positionId = positionByAllInfoAfterInsert.getPositionId();
            message.setPositionId(positionId);
        }
        // 上传者
        message.setCreator("管理员");
        int uploadBack = managerService.uploadMessage(message);
        if (uploadBack == 1) {
            return "redirect:/manager/toMessage";
        } else {
            return "manager/uploadMessage";
        }
    }

    /*
    登录注册模块
     */

    /**
     * 检查email是否可用
     *
     * @param email    前端传进的email
     * @param response http response
     */
    @PostMapping("/checkEmail")
    @ResponseBody
    public void checkEmail(@RequestParam("email") String email, HttpServletResponse
            response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 检查管理员email是否重复
        Manager manager = managerService.checkEmail(email);
        if (manager == null) {
            out.print("1");
        } else {
            out.print("2");
        }
        out.flush();
        out.close();
    }

    /**
     * 检查管理员名是否可用
     *
     * @param managerName 前端传进的管理员名
     * @param response    http response
     */
    @PostMapping("/checkManagerName")
    @ResponseBody
    public void checkManagerName(@RequestParam("managerName") String managerName, HttpServletResponse
            response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Manager manager = managerService.checkManagerName(managerName);
        if (manager == null) {
            out.print("1");
        } else {
            out.print("2");
        }
        out.flush();
        out.close();
    }

    /**
     * 管理员注册功能
     *
     * @param manager 管理员类信息
     * @param file    头像信息
     * @return 成功跳转至管理员登录页面，失败依旧在本页面
     */
    @PostMapping("/register")
    public String register(Manager manager, MultipartFile file, Map<String, Object> map) {
        // 用户密码MD5加密
        String password = manager.getPassword();
        String code = Md5Util.code(password);
        manager.setPassword(code);
        // 上传头像
        String url = null;
        try {
            url = uploadService.saveFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        manager.setAvatar(url);
        Date date = new Date();
        manager.setCreateTime(date);
        int registerBack = managerService.register(manager);
        if (registerBack == 1) {
            return "redirect:/manager/toLogin";
        } else {
            map.put("msg", "注册失败");
            return "manager/register";
        }
    }

    /**
     * 管理员注销功能
     *
     * @param request http request
     * @return 返回主页面
     */
    @GetMapping("/quitManager")
    public String quitUser(HttpServletRequest request) {
        // 获取当前session
        HttpSession session = request.getSession();
        // 移除manager
        session.removeAttribute("manager");
        return "redirect:/index";
    }

    /**
     * 登录功能
     *
     * @param managerName 用户名
     * @param password    密码
     * @return 返回loginUser，若不为空则登录成功
     */
    @PostMapping("/login")
    public String login(String managerName, String password, HttpServletRequest request) {
        // 用户密码MD5加密匹配
        password = Md5Util.code(password);
        HttpSession session = request.getSession(true);
        Manager loginManager = managerService.login(managerName, password);
        if (loginManager != null) {
            session.setAttribute("manager", loginManager);
            return "redirect:/manager/toMessage";
        } else {
            session.setAttribute("status", "登录失败");
            return "redirect:/status";
        }
    }

    /*
    页面跳转
     */

    @GetMapping("/toPosition")
    public String toPosition() {
        return "manager/position";
    }

    @GetMapping("/toCamera")
    public String toCamera() {
        return "manager/camera";
    }

    @GetMapping("/toUploadCamera")
    public String toUploadCamera() {
        return "manager/uploadCamera";
    }

    @GetMapping("/toUserImage")
    public String toUserImage() {
        return "manager/userImage";
    }

    @GetMapping("/toCameraImage")
    public String toCameraImage() {
        return "manager/cameraImage";
    }

    @GetMapping("/toUploadMessage")
    public String toUploadMessage() {
        return "manager/uploadMessage";
    }

    @GetMapping("/toMessage")
    public String toMessage() {
        return "manager/message";
    }

    @GetMapping("/toUserList")
    public String toUserList() {
        return "manager/userList";
    }

    @GetMapping("/toIndex")
    public String toIndex() {
        return "manager/index";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        return "manager/login";
    }

    @GetMapping("/toRegister")
    public String toRegister() {
        return "manager/register";
    }
}
