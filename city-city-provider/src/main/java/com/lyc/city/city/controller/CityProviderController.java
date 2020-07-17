package com.lyc.city.city.controller;

import com.lyc.city.bean.District;
import com.lyc.city.city.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 11:31
 */
@RestController
@Slf4j
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class CityProviderController {

    @Resource
    private CityService cityService;

    /**
     * 获取所有区/县信息
     * @param cityId 城市id
     * @return 所有区/县信息
     */
    @RequestMapping("/getAllDistrictByCity")
    @ResponseBody
    public List<District> getAllDistrictByCity(Integer cityId){
        return cityService.getAllDistrictByCity(cityId);
    }
}
