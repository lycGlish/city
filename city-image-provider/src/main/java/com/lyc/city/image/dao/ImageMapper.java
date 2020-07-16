package com.lyc.city.image.dao;

import com.lyc.city.bean.Image;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 10:37
 */
public interface ImageMapper {

    List<Image> selectAllImage();

    List<Image> selectAllImageBySource(String source);

    Integer insertImage(Image image);

    Integer deleteImageByImageId(Integer imageId);

    Integer updateImageResultByImageId(Image image);
}
