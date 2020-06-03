package com.nit.city.service.impl;

import com.nit.city.bean.Image;
import com.nit.city.dao.ImageMapper;
import com.nit.city.service.ImageSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图片逻辑层
 * @author lyc
 */
@Service
public class ImageServiceImpl implements ImageSevice {

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public Integer updateImage(Image image) {
        return imageMapper.updateByPrimaryKeySelective(image);
    }

    /**
     * 获取所有用户上传图片
     * @return 返回所有用户上传图片
     */
    @Override
    public List<Image> getAllSourceImage(String source) {
        return imageMapper.selectBySourceAll(source);
    }

    @Override
    public Integer deleteImage(Integer imageId) {
        return imageMapper.deleteByPrimaryKey(imageId);
    }

    @Override
    public List<Image> getAllImage() {
        return imageMapper.selectAll();
    }
}
