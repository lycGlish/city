package com.nit.city.service;


import com.nit.city.bean.City;
import com.nit.city.bean.Province;

import java.util.List;

public interface ProvinceService {

    Integer getProvinceIdByProvince(String province);

    List<City> getCity(Integer provinceId);

    List<Province> getAllProvince();
}
