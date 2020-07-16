package com.lyc.city.manager.service.impl;

import com.lyc.city.bean.Manager;
import com.lyc.city.manager.dao.ManagerMapper;
import com.lyc.city.manager.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lyc
 * @date 2020/7/15 14:44
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private ManagerMapper managerMapper;

    @Override
    public Manager login(String managerName, String password) {
        return managerMapper.selectByManagerNameAndPassword(managerName, password);
    }
}
