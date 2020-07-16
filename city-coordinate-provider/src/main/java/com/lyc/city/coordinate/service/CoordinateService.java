package com.lyc.city.coordinate.service;

import com.lyc.city.bean.Coordinate;

/**
 * @author lyc
 * @date 2020/7/8 17:30
 */
public interface CoordinateService {

    Integer uploadCoordinate(Coordinate coordinate);

    Coordinate getCoordinate(String longitude, String latitude);
}
