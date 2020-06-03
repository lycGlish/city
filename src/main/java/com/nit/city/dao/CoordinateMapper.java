package com.nit.city.dao;

import com.nit.city.bean.Coordinate;
import com.nit.city.bean.CoordinateExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CoordinateMapper {
    long countByExample(CoordinateExample example);

    int deleteByExample(CoordinateExample example);

    int deleteByPrimaryKey(Integer coordinateId);

    int insert(Coordinate record);

    int insertSelective(Coordinate record);

    int insertWithoutId(@Param("latitude") String latitude, @Param("longitude") String longitude);

    Coordinate selectByImageLatitudeAndImageLongitude(@Param("latitude") String latitude, @Param("longitude") String longitude);

    List<Coordinate> selectByExample(CoordinateExample example);

    Coordinate selectByPrimaryKey(Integer coordinateId);

    int updateByExampleSelective(@Param("record") Coordinate record, @Param("example") CoordinateExample example);

    int updateByExample(@Param("record") Coordinate record, @Param("example") CoordinateExample example);

    int updateByPrimaryKeySelective(Coordinate record);

    int updateByPrimaryKey(Coordinate record);
}