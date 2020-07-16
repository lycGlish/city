package com.lyc.city.user.service;

import com.lyc.city.bean.User;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/15 15:36
 */
public interface UserService {
    List<User> getAllUser();

    Integer deleteUserByUserId(Integer userId);
}
