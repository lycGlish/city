package com.lyc.city.image.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyc.city.bean.*;
import com.lyc.city.image.fastdfs.UploadService;
import com.lyc.city.image.service.ImageService;
import com.lyc.city.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lyc
 * @date 2020/7/8 16:37
 */
@Controller
@Slf4j
@CrossOrigin
public class ImageProviderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UploadService uploadService;

    @Resource
    private ImageService imageService;

    @PostMapping(value = "/updateImageResultByImageId")
    @ResponseBody
    public void updateImageResultByImageId(@RequestParam("modal_result") Integer result,
                                       @RequestParam("modal_imageId") Integer imageId) {
        Image image = new Image();
        image.setImageId(imageId);
        image.setResultId(result);
        image.setImageDescription("人工修改");
        // 注册时记录系统时间
        Date date = new Date();
        image.setImageTime(date);
        Integer backResult = imageService.updateImageResultByImageId(image);
        if(backResult==0){
            log.error("更新图片状态失败！");
        }
    }

    @GetMapping(value = "/deleteImageByImageId")
    @ResponseBody
    public void deleteImageByImageId(@RequestParam("imageId") Integer imageId) {
        int result = imageService.deleteImageByImageId(imageId);
        if (result == 0) {
            log.error("删除图片失败！");
        }
    }

    @GetMapping(value = "/getAllSourceImage")
    @ResponseBody
    public List<Image> getAllSourceImage(String source) {
        return imageService.getAllSourceImage(source);
    }

    @GetMapping(value = "/getAllImage")
    @ResponseBody
    public List<Image> getAllImage() {
        return imageService.getAllImage();
    }

    @PostMapping(value = "/uploadImage")
    public String uploadImage(String imageName, MultipartFile file, HttpSession session,
                              Integer province, Integer city, Integer district) {
        Image image = new Image();
        image.setImageName(imageName);
        image.setImageDescription("机器识别");

        String imageUrl = null;
        try {
            // 利用fastDFS存入服务器中并返回访问url
            imageUrl = uploadService.saveFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 图片url存入image对象
        image.setImageUrl(imageUrl);

        // 放入python中识别该图片状态
        String jsonImageUrl = PythonUtil.httpUrlConnectionPost(imageUrl);
        // 返回图片状态码
        String stringImageResult = JsonToString.getJsonToString(jsonImageUrl);
        int intResult = Integer.parseInt(stringImageResult);
        // 图片机器识别状态
        image.setResultId(intResult);

        // 查询数据库中是否有对应的position
        Integer positionId = null;
        Position positionByAllInfo = restTemplate.getForObject("http://city-position-provider/getPositionByAllInfo?province="
                + province + "&city=" + city + "&district=" + district, Position.class);
        if (positionByAllInfo != null) {
            positionId = positionByAllInfo.getPositionId();
        } else {
            // 未查到对应城市数据，插入该城市并返回positionId
            Position position = new Position();
            position.setProvinceId(province);
            position.setCityId(city);
            position.setDistrictId(district);
            Integer uploadPositionResult = restTemplate.postForObject("http://city-position-provider/uploadPosition",
                    position, Integer.class);
            if (uploadPositionResult != null && !uploadPositionResult.equals(0)) {
                positionByAllInfo = restTemplate.getForObject("http://city-position-provider/getPositionByAllInfo?province="
                        + province + "&city=" + city + "&district=" + district, Position.class);
                if (positionByAllInfo != null) {
                    positionId = positionByAllInfo.getPositionId();

                } else {
                    log.error("城市信息插入后,城市id查询失败！");
                }
            } else {
                log.error("插入城市信息失败！");
            }
        }
        // 坐标id存入image类
        image.setPositionId(positionId);

        String longitude = null, latitude = null;
        Map<String, String> fileCoordinate = FileUtil.fileCoordinateCheck(file);
        if (fileCoordinate != null) {
            longitude = fileCoordinate.get("longitude");
            latitude = fileCoordinate.get("latitude");
        } else {
            log.info("图片不带经纬度");
        }

        // 判断照片是否读取出经纬度
        if (longitude == null && latitude == null) {
            // 照片没有读取出经纬度
            Position positionByPositionId = restTemplate.getForObject("http://city-position-provider/getOtherInfoByPositionId?positionId="
                    + positionId, Position.class);
            if (positionByPositionId != null) {
                Province provinceBack = positionByPositionId.getProvince();
                String provinceName = provinceBack.getProvince();
                City cityBack = positionByPositionId.getCity();
                String cityName = cityBack.getCity();
                District districtBack = positionByPositionId.getDistrict();
                String districtName = districtBack.getDistrict();
                // 通过百度地图api搜索该地的坐标位置
                String coordinateApi = CityUtil.httpUrlConnectionPost(provinceName + cityName + districtName + imageName);
                if (coordinateApi != null) {
                    coordinateApi = coordinateApi.substring(27);
                    coordinateApi = coordinateApi.substring(0, coordinateApi.length() - 1);
                } else {
                    log.error("coordinateApi为空！");
                }
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
                    if(coordinateApi!=null){
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
            } else {
                log.error("用positionId查询城市信息失败！");
            }

        }

        Integer coordinateId = null;
        // 调用coordinate服务查询坐标是否存在
        Coordinate coordinate = restTemplate.getForObject("http://city-coordinate-provider/getCoordinate?longitude="
                + longitude + "&latitude=" + latitude, Coordinate.class);
        if (coordinate != null) {
            // 已存在则获取coordinateId
            coordinateId = coordinate.getCoordinateId();
        } else {
            // 不存在则插入并返回coordinateId
            Coordinate uploadCoordinate = new Coordinate();
            uploadCoordinate.setLongitude(longitude);
            uploadCoordinate.setLatitude(latitude);
            Integer uploadCoordinateResult = restTemplate.postForObject("http://city-coordinate-provider/uploadCoordinate"
                    , uploadCoordinate, Integer.class);
            // 插入结果不为0
            if (uploadCoordinateResult != null && !uploadCoordinateResult.equals(0)) {
                // 通过前端传来的坐标信息进行重新查询
                coordinate = restTemplate.getForObject("http://city-coordinate-provider/getCoordinate?longitude=" + longitude
                        + "&latitude=" + latitude, Coordinate.class);
                if (coordinate != null) {
                    coordinateId = coordinate.getCoordinateId();
                } else {
                    log.error("坐标插入后,坐标查询失败！");
                }
            } else {
                log.error("坐标插入失败!");
            }
        }
        // 将coordinateId存入image对象
        image.setCoordinateId(coordinateId);

        // 从session中获取当前用户信息
//        User user = (User) session.getAttribute("user");
//        Integer userId = user.getUserId();
        image.setUserId(6);

        // 图片已被识别标记为2
        image.setStatus("2");

        // 该方法上传的图片均标记为用户上传
        image.setSource("用户");

        // 注册时记录系统时间
        Date date = new Date();
        image.setImageTime(date);

        // 特殊路况，系统自动给地图发送消息
        if (intResult != 1) {
            // 封装message类
            Message message = new Message();
            message.setMessageName("系统上传");
            message.setMessageDescription("系统上传");
            message.setCoordinateId(coordinateId);
            message.setPositionId(positionId);
            message.setCreateTime(date);
            message.setCreator("匿名");
            message.setImageUrl(imageUrl);
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
                    log.error("系统自动发布预警消息错误！");
            }
            Integer uploadMessageResult = restTemplate.postForObject("http://city-message-provider/uploadMessage"
                    , message, Integer.class);
            if (uploadMessageResult != null && !uploadMessageResult.equals(0)) {
                log.info("系统自动发布预警消息成功！");
            } else {
                log.error("系统自动发布预警消息失败！");
            }
        }

        // 将整体image信息存入数据库
        int uploadImageResult = imageService.uploadImage(image);
        if (uploadImageResult == 1) {
            // 成功则跳转至查看图片界面
            return "redirect:http://localhost:6021/index";
        } else {
            session.setAttribute("status", "登录失败");
            return "redirect:http://localhost:6011/status";
        }
    }
}
