package com.lyc.city.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate implements Serializable {
    private Integer coordinateId;

    private String latitude;

    private String longitude;
}