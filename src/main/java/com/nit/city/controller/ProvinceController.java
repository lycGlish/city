package com.nit.city.controller;

import com.nit.city.bean.City;
import com.nit.city.bean.Province;
import com.nit.city.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lyc
 */
@Controller
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    /**
     * 查询所有省份信息
     * @return 所有省份信息
     */
    @RequestMapping("/getAllProvince")
    @ResponseBody
    public List<Province> getAllProvince(){
        List<Province> provinces = provinceService.getAllProvince();
        return provinces;
    }

    /**
     * 查询当前省份下所有城市信息
     * @param provinceId 省份id
     * @return 城市信息
     */
    @RequestMapping("/getCity")
    @ResponseBody
    public List<City> getCity(Integer provinceId){
        List<City> city = provinceService.getCity(provinceId);
        return city;
    }
}
