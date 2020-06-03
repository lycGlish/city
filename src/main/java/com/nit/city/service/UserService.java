package com.nit.city.service;

import com.nit.city.bean.Image;
import com.nit.city.bean.Message;
import com.nit.city.bean.User;

import java.util.List;

public interface UserService {

    List<Image> getUserImage(int userId);

    int uploadImage(Image image);

    User checkEmail(String email);

    User checkUserName(String userName);

    List<User> getAllUser();

    User login(String userName, String password);

    int register(User user);

    int uploadMessage(Message message);
}
