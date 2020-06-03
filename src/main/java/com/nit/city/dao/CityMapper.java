package com.nit.city.dao;

import com.nit.city.bean.City;
import com.nit.city.bean.CityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import javax.persistence.criteria.CriteriaBuilder;

public interface CityMapper {
    long countByExample(CityExample example);

    int deleteByExample(CityExample example);

    int deleteByPrimaryKey(Integer cityId);

    int insert(City record);

    int insertSelective(City record);

    Integer selectByCity(String city);

    City selectByProvinceId(String provinceId);

    List<City> selectByProvinceId(Integer provinceId);

    List<City> selectByExample(CityExample example);

    City selectByPrimaryKey(Integer cityId);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

    int updateByExample(@Param("record") City record, @Param("example") CityExample example);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}