package com.nit.city.service;

import com.nit.city.bean.Image;

import java.util.List;

/**
 * @author lyc
 */
public interface ImageSevice {

    Integer updateImage(Image image);

    List<Image> getAllSourceImage(String source);

    Integer deleteImage(Integer imageId);

    List<Image> getAllImage();
}
