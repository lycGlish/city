package com.lyc.city.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 道路图片状态实体类
 * @author lyc
 * @date 2020/7/6 9:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {

    // 状态id
    private Integer resultId;

    // 状态名称
    private String resultName;
}