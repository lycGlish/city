package com.nit.city.controller;

import com.alibaba.fastjson.JSONObject;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.nit.city.bean.*;
import com.nit.city.fastdfs.UploadService;
import com.nit.city.service.CoordinateService;
import com.nit.city.service.ImageSevice;
import com.nit.city.service.IndexService;
import com.nit.city.service.PositionService;
import com.nit.city.util.CityUtil;
import com.nit.city.util.JsonToString;
import com.nit.city.util.PointUtil;
import com.nit.city.util.PythonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * 主页面业务层
 *
 * @author lyc
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ImageSevice imageSevice;

    @Autowired
    private IndexService indexService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private CoordinateService coordinateService;

    @Autowired
    private UploadService uploadService;

    /**
     * 查询所有图片
     *
     * @return 返回所有图片
     */
    @GetMapping("/getAllImage")
    @ResponseBody
    public List<Image> getAllCameraImage() {
        return imageSevice.getAllImage();
    }

    /**
     * 主页上传图片
     * @param imageName 图片名称
     * @param file 前端传进的图片
     * @param province 省份
     * @param city 城市
     * @param district 区/县
     * @param request
     * @return 成功跳转至查看所有自己上传图片页面，失败依旧在本页面
     */
    @PostMapping("/uploadImage")
    public String uploadImage(String imageName, MultipartFile file
            , Integer province, Integer city, Integer district, HttpServletRequest request) {
        // 封装image类
        Image image = new Image();
        image.setImageName(imageName);
        image.setImageDescription("机器识别");

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
        int intResult = Integer.parseInt(stringResult);
        // 从session中获取当前用户信息（暂时停用用户系统）
//        User user = (User) session.getAttribute("user");
//        Integer userId = user.getUserId();
        // 直接封装用户信息,为匿名
        image.setUserId(6);
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
            positionByAllInfo = positionService.getPositionByAllInfo(province, city, district);
            // 查询到数据库有对应城市
            positionId = positionByAllInfo.getPositionId();
        }
        image.setPositionId(positionId);

        // 查询输入坐标数据库是否存在
        String latitude = null;
        String longitude = null;
        File localFile;
        try {
            // 判断上传图片是否自带经纬度坐标与时间
            localFile = File.createTempFile("tmp", null);
            file.transferTo(localFile);
            Metadata metadata = ImageMetadataReader.readMetadata(localFile);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    String tagName = tag.getTagName();  //标签名
                    String desc = tag.getDescription(); //标签信息
                    switch (tagName) {
//                        case "Image Height":
//                            System.out.println("图片高度: " + desc);
//                            break;
//                        case "Image Width":
//                            System.out.println("图片宽度: " + desc);
//                            break;
                        case "Date/Time Original":
                            log.info("拍摄时间:" + desc);
                            break;
                        case "GPS Latitude":
                            longitude = PointUtil.pointToLatlong(desc);
                            log.info("纬度 : " + PointUtil.pointToLatlong(desc));
//                            System.err.println("纬度(度分秒格式) : " + PointUtil.pointToLatlong(desc));
                            break;
                        case "GPS Longitude":
                            latitude = PointUtil.pointToLatlong(desc);
                            log.info("经度: " + PointUtil.pointToLatlong(desc));
//                            System.err.println("经度(度分秒格式): " + PointUtil.pointToLatlong(desc));
                            break;
                    }
                }
            }
            localFile.deleteOnExit();
        } catch (IOException | ImageProcessingException e) {
            e.printStackTrace();
        }
        if (longitude == null && latitude == null) {
            // 读取选择的省市县信息
            Position positionByPositionId = positionService.getOtherInfoByPositionId(positionId);
            Province provinceBack = positionByPositionId.getProvince();
            String provinceName = provinceBack.getProvince();
            City cityBack = positionByPositionId.getCity();
            String cityName = cityBack.getCity();
            District districtBack = positionByPositionId.getDistrict();
            String districtName = districtBack.getDistrict();
            // 通过百度地图api搜索该地的坐标位置
            String coordinateApi = CityUtil.httpUrlConnectionPost(provinceName + cityName + districtName + imageName);
            coordinateApi = coordinateApi.substring(27);
            coordinateApi = coordinateApi.substring(0, coordinateApi.length() - 1);
            JSONObject json = JSONObject.parseObject(coordinateApi);
            // 搜索到用户输入的街道信息
            if (json.get("status").toString().equals("0")) {
                log.info("查找到匹配的经纬度！");
                latitude = json.getJSONObject("result").getJSONObject("location").getString("lng");
                longitude = json.getJSONObject("result").getJSONObject("location").getString("lat");
            } else {
                log.info("未找到相匹配的经纬度！");
                // 没有搜索到用户输入的街道信息，填入省市县坐标
                coordinateApi = CityUtil.httpUrlConnectionPost(provinceName + cityName + districtName);
                coordinateApi = coordinateApi.substring(27);
                coordinateApi = coordinateApi.substring(0, coordinateApi.length() - 1);
                json = JSONObject.parseObject(coordinateApi);
                if (json.get("status").toString().equals("0")) {
                    latitude = json.getJSONObject("result").getJSONObject("location").getString("lng");
                    longitude = json.getJSONObject("result").getJSONObject("location").getString("lat");
                } else {
                    log.info("程序错误！");
                }
            }
        }

        // 传入经纬度查询是否存在
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

        // 注册时记录系统时间
        Date date = new Date();
        image.setImageTime(date);

        // 图片识别后,不为无积水时，系统自动给地图发送消息
        if (intResult != 1) {
            Message message = new Message();
            message.setMessageName("系统上传");
            message.setMessageDescription("系统识别");
            message.setCoordinateId(coordinateId);
            message.setPositionId(positionId);
            message.setCreateTime(date);
            message.setCreator("匿名");
            message.setImageUrl(url);
            switch (intResult) {
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
                    log.info("错误");
            }
            int uploadMessage = indexService.uploadMessage(message);
            if (uploadMessage == 0) {
                log.info("发布消息失败");
            } else {
                log.info("发布消息成功");
            }
        }
        // 将整体image信息存入数据库
        int status = indexService.uploadImage(image);
        HttpSession session = request.getSession(true);
        if (status == 0) {
            session.setAttribute("status", "上传失败");
        } else {
            session.setAttribute("status", "上传成功");
        }
        return "redirect:/status";
    }

    /*
     * 页面跳转
     */

    @GetMapping("/status")
    public String status() {
        return "status";
    }

    @GetMapping("/500")
    public String wrong() {
        return "error/500";
    }

    @GetMapping("/404")
    public String lost() {
        return "error/404";
    }

    @GetMapping("/")
    public String index1() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/test/city")
    public String city() {
        return "test/city";
    }

    @GetMapping("/test")
    public String test() {
        return "test/test";
    }

}
