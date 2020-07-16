package com.lyc.city.city.service.impl;

import com.lyc.city.bean.District;
import com.lyc.city.city.dao.CityMapper;
import com.lyc.city.city.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 11:32
 */
@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityMapper cityMapper;

    @Override
    public List<District> getDistrictByCity(Integer cityId) {
        return cityMapper.selectDistrictByCity(cityId);
    }
}
