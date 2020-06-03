package com.nit.city.service.impl;

import com.nit.city.bean.Image;
import com.nit.city.bean.Message;
import com.nit.city.bean.User;
import com.nit.city.dao.ImageMapper;
import com.nit.city.dao.MessageMapper;
import com.nit.city.dao.UserMapper;
import com.nit.city.service.IndexService;
import com.nit.city.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private ImageMapper imageMapper;


    @Override
    public int uploadMessage(Message message) {
        return messageMapper.insertSelective(message);
    }

    @Override
    public int uploadImage(Image image) {
        return imageMapper.insertSelective(image);
    }
}
