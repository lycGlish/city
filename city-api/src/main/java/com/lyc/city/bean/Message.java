package com.lyc.city.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 预警消息实体类
 * @author lyc
 * @date 2020/7/6 9:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    // 预警消息id
    private Integer messageId;

    // 预警消息来源
    private String messageName;

    // 预警消息描述（人工修改/系统上传）
    private String messageDescription;

    // 坐标id
    private Integer coordinateId;

    // 位置id
    private Integer positionId;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    // 预警消息状态
    private String result;

    // 创建人
    private String creator;

    // 图片网页地址
    private String imageUrl;

    // 坐标实体类
    private Coordinate coordinate;

    // 省份实体类
    private Province province;

    // 城市实体类
    private City city;

    // 区/县实体类
    private District district;
}