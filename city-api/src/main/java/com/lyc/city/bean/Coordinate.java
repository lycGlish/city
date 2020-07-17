package com.lyc.city.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 坐标实体类
 * @author lyc
 * @date 2020/7/6 9:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate implements Serializable {

    // 坐标id
    private Integer coordinateId;

    // 经度
    private String longitude;

    // 纬度
    private String latitude;
}