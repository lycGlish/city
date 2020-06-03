package com.nit.city.service.impl;

import com.nit.city.bean.District;
import com.nit.city.dao.CityMapper;
import com.nit.city.dao.DistrictMapper;
import com.nit.city.service.CityService;
import com.nit.city.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lyc
 */
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public Integer getDistrictIdByDistrict(String district) {
        Integer districtId = districtMapper.selectByDistrict(district);
        return districtId;
    }
}
