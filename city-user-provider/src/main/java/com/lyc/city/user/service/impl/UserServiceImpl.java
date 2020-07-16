package com.lyc.city.user.service.impl;

import com.lyc.city.bean.User;
import com.lyc.city.user.dao.UserMapper;
import com.lyc.city.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lyc
 * @date 2020/7/15 15:36
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public Integer deleteUserByUserId(Integer userId) {
        return userMapper.deleteUserByUserId(userId);
    }
}
