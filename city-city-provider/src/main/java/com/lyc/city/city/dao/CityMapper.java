package com.lyc.city.city.dao;

import com.lyc.city.bean.District;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 11:34
 */
@Mapper
public interface CityMapper {

    List<District> selectAllDistrictByCity(Integer cityId);
}
