package com.lyc.city.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position implements Serializable {
    private Integer positionId;

    private Integer provinceId;

    private Integer cityId;

    private Integer districtId;

    private Province province;

    private City city;

    private District district;
}