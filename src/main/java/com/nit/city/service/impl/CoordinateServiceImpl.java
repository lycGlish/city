package com.nit.city.service.impl;

import com.nit.city.bean.Coordinate;
import com.nit.city.dao.CoordinateMapper;
import com.nit.city.service.CoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinateServiceImpl implements CoordinateService {

    @Autowired
    private CoordinateMapper coordinateMapper;

    @Override
    public int uploadCoordinate(String latitude, String longitude) {
        int result = coordinateMapper.insertWithoutId(latitude, longitude);
        return result;
    }

    @Override
    public Coordinate getCoordinate(String latitude, String longitude) {
        Coordinate coordinate = coordinateMapper.selectByImageLatitudeAndImageLongitude(latitude, longitude);
        return coordinate;
    }
}
