package com.lyc.city.camera.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyc.city.bean.*;
import com.lyc.city.camera.service.CameraService;
import com.lyc.city.utils.CityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lyc
 * @date 2020/7/15 15:28
 */

@Controller
@Slf4j
@CrossOrigin
public class CameraProviderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private CameraService cameraService;

    /**
     * 修改摄像头具体位置
     * @param cameraName 摄像头具体位置
     * @param cameraId 摄像头id
     */
    @PostMapping("/updateCameraNameByCameraId")
    @ResponseBody
    public void updateCameraNameByCameraId(@RequestParam("modal_cameraName") String cameraName,
                               @RequestParam("modal_cameraId") Integer cameraId) {
        Camera camera = new Camera();
        camera.setCameraId(cameraId);
        camera.setCameraName(cameraName);
        int result = cameraService.updateCameraNameByCameraId(camera);
        if(result!=0){
            log.info("更新摄像头成功！");
        }else {
            log.error("更新摄像头失败！");
        }
    }

    /**
     * 修改摄像头
     * @param cameraId 摄像头id
     */
    @GetMapping("/deleteCameraByCameraId")
    @ResponseBody
    public void deleteCameraByCameraId(@RequestParam("cameraId") Integer cameraId) {
        int result = cameraService.deleteCameraByCameraId(cameraId);
        if(result!=0){
            log.info("删除摄像头成功！");
        }else {
            log.error("删除摄像头失败！");
        }
    }

    /**
     * 获取所有摄像头信息
     * @return 所有摄像头信息
     */
    @GetMapping("/getAllCamera")
    @ResponseBody
    public List<Camera> getAllCamera() {
        return cameraService.getAllCamera();
    }

    /**
     * 上传摄像头信息
     * @param cameraName 摄像头具体位置
     * @param province 省份
     * @param city 城市
     * @param district 区/县
     * @param request request对象
     * @return 查看摄像头信息页面
     */
    @PostMapping("/uploadCamera")
    public String uploadCamera(String cameraName, Integer province, Integer city, Integer district, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        // 封装camera类
        Camera camera = new Camera();
        camera.setCameraName(cameraName);

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
        // 坐标id存入camera类
        camera.setPositionId(positionId);

        // 查询输入坐标数据库是否存在
        String latitude = null;
        String longitude = null;

        // 读取选择的省市县信息
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
            String coordinateApi = CityUtil.httpUrlConnectionPost(provinceName + cityName + districtName + cameraName);
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
        camera.setCoordinateId(coordinateId);

        int result = cameraService.uploadCamera(camera);
        if (result != 0) {
            log.info("上传摄像头成功！");
            return "redirect:http://localhost:6001/toCamera";
        } else {
            session.setAttribute("status", "上传摄像头失败");
            return "redirect:http://localhost:6011/status";
        }
    }
}
