package com.nit.city.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Camera implements Serializable {
    private Integer cameraId;

    private String cameraName;

    private Integer coordinateId;

    private Integer positionId;

    private Coordinate coordinate;

    private Position position;

    private Province province;

    private City city;

    private District district;
}