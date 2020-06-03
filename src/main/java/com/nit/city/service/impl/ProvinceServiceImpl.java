package com.nit.city.service.impl;

import com.nit.city.bean.City;
import com.nit.city.bean.Province;
import com.nit.city.dao.CityMapper;
import com.nit.city.dao.ProvinceMapper;
import com.nit.city.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private CityMapper cityMapper;


    @Override
    public Integer getProvinceIdByProvince(String province) {
        Integer provinceId = provinceMapper.selectByProvince(province);
        return provinceId;
    }

    @Override
    public List<City> getCity(Integer provinceId) {
        List<City> cities = cityMapper.selectByProvinceId(provinceId);
        return cities;
    }

    @Override
    public List<Province> getAllProvince() {
        List<Province> provinces = provinceMapper.selectAll();
        return provinces;
    }
}
