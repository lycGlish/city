package com.lyc.city.manager.service;

import com.lyc.city.bean.Manager;

import javax.annotation.Resource;

/**
 * @author lyc
 * @date 2020/7/15 14:44
 */
public interface ManagerService {

    Manager login(String managerName, String password);
}
