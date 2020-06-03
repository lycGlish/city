package com.nit.city.service.impl;

import com.nit.city.bean.Image;
import com.nit.city.bean.Message;
import com.nit.city.bean.User;
import com.nit.city.dao.ImageMapper;
import com.nit.city.dao.MessageMapper;
import com.nit.city.dao.UserMapper;
import com.nit.city.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MessageMapper messageMapper;
    
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public List<Image> getUserImage(int userId) {
        List<Image> userImages = imageMapper.selectByUserId(userId);
        return userImages;
    }

    @Override
    public int uploadImage(Image image) {
        return imageMapper.insertSelective(image);
    }

    @Override
    public User checkEmail(String email) {
        User checkEmail = userMapper.selectByEmail(email);
        return checkEmail;
    }

    @Override
    public User checkUserName(String userName){
        User checkUser = userMapper.selectByUserName(userName);
        return checkUser;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userMapper.selectAllUser();
        return users;
    }

    @Override
    public User login(String userName,String password){
        User loginUser = userMapper.selectByUserNameAndPassword(userName, password);
        return loginUser;
    }

    @Override
    public int register(User user) {
        int registerBack = userMapper.insertSelective(user);
        return registerBack;
    }

    @Override
    public int uploadMessage(Message message) {
        int i = messageMapper.insertSelective(message);
        return i;
    }
}
