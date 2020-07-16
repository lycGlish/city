package com.lyc.city.city.service;

import com.lyc.city.bean.District;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 11:32
 */
public interface CityService {

    List<District> getDistrictByCity(Integer cityId);
}
