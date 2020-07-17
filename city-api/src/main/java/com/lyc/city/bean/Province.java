package com.lyc.city.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 摄像头实体类
 * @author lyc
 * @date 2020/7/6 9:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {

    // 省份id
    private Integer provinceId;

    // 省份名称
    private String province;
}