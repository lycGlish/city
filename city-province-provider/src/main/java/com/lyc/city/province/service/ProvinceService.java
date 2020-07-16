package com.lyc.city.province.service;

import com.lyc.city.bean.City;
import com.lyc.city.bean.Province;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 11:17
 */
public interface ProvinceService {

    List<Province> getAllProvince();

    List<City> getCityByProvince(Integer provinceId);
}
