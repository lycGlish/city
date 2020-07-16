package com.lyc.city.position.service;

import com.lyc.city.bean.Position;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 10:25
 */
public interface PositionService {

    Position getOtherInfoByPositionId(Integer positionId);

    Position getPositionByAllInfo(Integer province, Integer city, Integer district);

    Integer uploadPosition(Position position);

    List<Position> getAllPosition();

    Integer deletePositionByPositionId(Integer positionId);
}
