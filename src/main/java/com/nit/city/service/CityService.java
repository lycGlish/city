package com.nit.city.service;


import com.nit.city.bean.City;
import com.nit.city.bean.District;

import java.util.List;

public interface CityService {

    Integer getCityIdByCity(String city);

    List<District> getDistrict(Integer districtId);
}
