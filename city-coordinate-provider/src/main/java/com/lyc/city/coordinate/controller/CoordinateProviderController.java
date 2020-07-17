package com.lyc.city.coordinate.controller;

import com.lyc.city.bean.Coordinate;
import com.lyc.city.coordinate.service.CoordinateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lyc
 * @date 2020/7/8 17:19
 */
@Controller
@CrossOrigin
@Slf4j
public class CoordinateProviderController {

    @Resource
    CoordinateService coordinateService;

    /**
     * 查询坐标信息
     * @param longitude 经度
     * @param latitude 纬度
     * @return 坐标信息
     */
    @GetMapping(value = "/getCoordinate")
    @ResponseBody
    public Coordinate getCoordinate(String longitude, String latitude){
//        log.info("调用查询坐标服务");
        return coordinateService.getCoordinate(longitude, latitude);
    }

    /**
     * 上传坐标信息
     * @param uploadCoordinate 坐标类
     * @return 上传结果
     */
    @PostMapping(value = "/uploadCoordinate")
    @ResponseBody
    public Integer uploadCoordinate(@RequestBody Coordinate uploadCoordinate){
        return coordinateService.uploadCoordinate(uploadCoordinate);
    }
}
