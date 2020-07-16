package com.lyc.city.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private Integer imageId;

    private String imageName;

    private String imageUrl;

    private String status;

    private String imageDescription;

    private String source;

    private Integer positionId;

    private Integer resultId;

    private Integer userId;

    private Integer coordinateId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date imageTime;

    private Position position;

    private Result result;

    private User user;

    private Coordinate coordinate;

    private Province province;

    private City city;

    private District district;
}