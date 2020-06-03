package com.nit.city.dao;

import com.nit.city.bean.Manager;
import com.nit.city.bean.ManagerExample;
import java.util.List;

import com.nit.city.bean.User;
import org.apache.ibatis.annotations.Param;

public interface ManagerMapper {
    long countByExample(ManagerExample example);

    int deleteByExample(ManagerExample example);

    int deleteByPrimaryKey(Integer managerId);

    int insert(Manager record);

    int insertSelective(Manager record);

    List<Manager> selectByExample(ManagerExample example);

    Manager selectByManagerName(String userName);

    Manager selectByEmail(String email);

    Manager selectByPrimaryKey(Integer managerId);

    Manager selectByManagerNameAndPassword(@Param("managerName") String managerName,@Param("password") String password);

    int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}