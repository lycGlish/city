package com.lyc.city.province.service.impl;

import com.lyc.city.bean.City;
import com.lyc.city.bean.Province;
import com.lyc.city.province.dao.ProvinceMapper;
import com.lyc.city.province.service.ProvinceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 11:17
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Resource
    private ProvinceMapper provinceMapper;

    @Override
    public List<Province> getAllProvince() {
        return provinceMapper.selectAllProvince();
    }

    @Override
    public List<City> getCityByProvince(Integer provinceId) {
        return provinceMapper.selectCityByProvince(provinceId);
    }
}
