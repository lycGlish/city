package com.nit.city.dao;

import com.nit.city.bean.Position;
import com.nit.city.bean.PositionExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PositionMapper {
    long countByExample(PositionExample example);

    int deleteByExample(PositionExample example);

    int deleteByPrimaryKey(Integer positionId);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectAllPosition();

    Position selectOtherInfoByPositionId(Integer positionId);

    Position selectByAllInfo(@Param("provinceId")Integer provinceId,@Param("cityId")Integer cityId,@Param("districtId")Integer districtId);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(Integer positionId);

    int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}