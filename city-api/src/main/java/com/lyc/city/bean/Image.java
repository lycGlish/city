package com.lyc.city.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 图片实体类
 * @author lyc
 * @date 2020/7/6 9:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    // 图片id
    private Integer imageId;

    // 道路图片具体位置
    private String imageName;

    // 图片网页地址
    private String imageUrl;

    // 图片被机器识别状态（1未识别，2已识别）
    private String status;

    // 图片识别描述（机器识别，人工识别）
    private String imageDescription;

    // 图片上传来源
    private String source;

    // 坐标id
    private Integer positionId;

    // 道路图片状态id
    private Integer resultId;

    // 用户id
    private Integer userId;

    // 坐标id
    private Integer coordinateId;

    // 上传图片时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date imageTime;

    // 位置实体类
    private Position position;

    // 道路图片状态实体类
    private Result result;

    // 用户实体类
    private User user;

    // 坐标实体类
    private Coordinate coordinate;

    // 省份实体类
    private Province province;

    // 城市实体类
    private City city;

    // 区/县实体类
    private District district;
}