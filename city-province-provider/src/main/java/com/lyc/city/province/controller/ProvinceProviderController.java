package com.lyc.city.province.controller;

import com.lyc.city.bean.City;
import com.lyc.city.bean.Province;
import com.lyc.city.province.service.ProvinceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 11:15
 */
@Controller
@Slf4j
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ProvinceProviderController {

    @Resource
    private ProvinceService provinceService;

    @GetMapping("getAllProvince")
    @ResponseBody
    public List<Province> getAllProvince(){
        return provinceService.getAllProvince();
    }

    @RequestMapping("/getAllCityByProvince")
    @ResponseBody
    public List<City> getAllCityByProvince(Integer provinceId){
        return provinceService.getAllCityByProvince(provinceId);
    }
}
