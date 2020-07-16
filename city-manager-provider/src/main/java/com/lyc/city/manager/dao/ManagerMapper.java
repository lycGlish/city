package com.lyc.city.manager.dao;

import com.lyc.city.bean.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lyc
 * @date 2020/7/15 14:44
 */
@Mapper
public interface ManagerMapper {
    Manager selectByManagerNameAndPassword(@Param("managerName") String managerName, @Param("password") String password);
}
