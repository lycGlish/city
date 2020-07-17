package com.lyc.city.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 摄像头实体类
 * @author lyc
 * @date 2020/7/6 9:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Camera implements Serializable {

    // 摄像头id
    private Integer cameraId;

    // 摄像头具体地址（街道/地点）
    private String cameraName;

    // 坐标id
    private Integer coordinateId;

    // 位置id
    private Integer positionId;

    // 坐标实体类
    private Coordinate coordinate;

    // 位置实体类
    private Position position;

    // 省份实体类
    private Province province;

    // 城市实体类
    private City city;

    // 区/县实体类
    private District district;
}