package com.lyc.city.coordinate.service.impl;

import com.lyc.city.bean.Coordinate;
import com.lyc.city.coordinate.dao.CoordinateMapper;
import com.lyc.city.coordinate.service.CoordinateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lyc
 * @date 2020/7/8 17:31
 */
@Service
public class CoordinateServiceImpl implements CoordinateService {

    @Resource
    private CoordinateMapper coordinateMapper;

    @Override
    public Integer uploadCoordinate(Coordinate coordinate) {
        return coordinateMapper.insertCoordinateWithoutId(coordinate);
    }

    @Override
    public Coordinate getCoordinate(String longitude, String latitude) {
        return coordinateMapper.selectByImageLatitudeAndImageLongitude(longitude, latitude);
    }
}
