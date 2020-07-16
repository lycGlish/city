package com.lyc.city.position.dao;

import com.lyc.city.bean.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 10:57
 */
public interface PositionMapper {

    Position selectOtherInfoByPositionId(Integer positionId);

    Position selectByAllInfo(@Param("provinceId") Integer provinceId,@Param("cityId") Integer cityId,@Param("districtId") Integer districtId);

    int insertPosition(Position position);

    List<Position> selectAllPosition();

    Integer deletePositionByPositionId(Integer positionId);
}
