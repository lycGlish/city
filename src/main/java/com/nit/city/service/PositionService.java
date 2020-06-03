package com.nit.city.service;

import com.nit.city.bean.Position;

import java.util.List;

public interface PositionService {

    Position getOtherInfoByPositionId(Integer positionId);

    Position getPositionByAllInfo(Integer provinceId,Integer cityId,Integer districtId);

    Integer uploadPosition(Position position);

    List<Position> getAllPosition();

    void deletePosition(Integer positionId);
}
