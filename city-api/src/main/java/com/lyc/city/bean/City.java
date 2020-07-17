package com.lyc.city.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 城市实体类
 * @author lyc
 * @date 2020/7/6 9:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {

    // 城市id
    private Integer cityId;

    // 省份id
    private Integer provinceId;

    // 城市名称
    private String city;
}