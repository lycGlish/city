package com.lyc.city.province.dao;

import com.lyc.city.bean.City;
import com.lyc.city.bean.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 11:20
 */
@Mapper
public interface ProvinceMapper {

    List<City> selectAllCityByProvince(Integer provinceId);

    List<Province> selectAllProvince();
}
