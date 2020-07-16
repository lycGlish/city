package com.lyc.city.user.dao;

import com.lyc.city.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/15 15:37
 */
@Mapper
public interface UserMapper {
    List<User> selectAllUser();

    Integer deleteUserByUserId(Integer userId);
}
