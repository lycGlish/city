package com.nit.city.controller;

import com.nit.city.bean.District;
import com.nit.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lyc
 */
@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 查询区县
     * @param cityId 城市id
     * @return 该城市下属所有区县
     */
    @RequestMapping("/getDistrict")
    @ResponseBody
    public List<District> getDistrict(Integer cityId){
        return cityService.getDistrict(cityId);
    }
}
