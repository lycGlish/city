package com.lyc.city.image.service;

import com.lyc.city.bean.Image;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/8 18:08
 */
public interface ImageService {

    List<Image> getAllSourceImage(String source);

    List<Image> getAllImage();

    Integer uploadImage(Image image);

    Integer deleteImageByImageId(Integer imageId);

    Integer updateImageResultByImageId(Image image);
}
