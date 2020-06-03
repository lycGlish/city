package com.nit.city.service;

import com.nit.city.bean.Coordinate;

public interface CoordinateService {

    int uploadCoordinate(String latitude, String longitude);

    Coordinate getCoordinate(String latitude, String longitude);
}
