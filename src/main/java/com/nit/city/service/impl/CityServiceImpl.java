package com.nit.city.service.impl;

import com.nit.city.bean.City;
import com.nit.city.bean.District;
import com.nit.city.dao.CityMapper;
import com.nit.city.dao.DistrictMapper;
import com.nit.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lyc
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public Integer getCityIdByCity(String city) {
        Integer cityId = cityMapper.selectByCity(city);
        return cityId;
    }

    @Override
    public List<District> getDistrict(Integer cityId) {
        List<District> districts = districtMapper.selectByCityId(cityId);
        return districts;
    }
}
