package com.lyc.city.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lyc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District implements Serializable {
    private Integer districtId;

    private Integer cityId;

    private String district;
}