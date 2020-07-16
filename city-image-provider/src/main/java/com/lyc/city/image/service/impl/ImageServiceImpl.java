package com.lyc.city.image.service.impl;

import com.lyc.city.bean.Image;
import com.lyc.city.image.dao.ImageMapper;
import com.lyc.city.image.service.ImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 10:37
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Resource
    private ImageMapper imageMapper;

    @Override
    public List<Image> getAllSourceImage(String source) {
        return imageMapper.selectAllImageBySource(source);
    }

    @Override
    public List<Image> getAllImage() {
        return imageMapper.selectAllImage();
    }

    @Override
    public Integer uploadImage(Image image) {
        return imageMapper.insertImage(image);
    }

    @Override
    public Integer deleteImageByImageId(Integer imageId) {
        return imageMapper.deleteImageByImageId(imageId);
    }

    @Override
    public Integer updateImageResultByImageId(Image image) {
        return imageMapper.updateImageResultByImageId(image);
    }


}
