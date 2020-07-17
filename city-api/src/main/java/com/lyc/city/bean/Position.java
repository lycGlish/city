package com.lyc.city.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 位置实体类
 * @author lyc
 * @date 2020/7/6 9:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position implements Serializable {

    // 位置id
    private Integer positionId;

    // 省份id
    private Integer provinceId;

    // 城市id
    private Integer cityId;

    // 区/县id
    private Integer districtId;

    // 省份实体类
    private Province province;

    // 城市实体类
    private City city;

    // 区/县实体类
    private District district;
}