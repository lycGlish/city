package com.lyc.city.manager.controller;

import com.lyc.city.bean.Manager;
import com.lyc.city.manager.service.ManagerService;
import com.lyc.city.utils.Md5Util;
import com.lyc.city.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lyc
 * @date 2020/7/15 14:43
 */
@Controller
@Slf4j
@CrossOrigin
public class ManagerProviderController {

    @Resource
    private ManagerService managerService;

    /**
     * 管理员注销
     * @return 主页面
     */
    @GetMapping("/quitManager")
    public String quitUser() {
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.del("managerName");
        return "redirect:http://localhost:6021/index";
    }

    /**
     * 管理员登录
     * @param managerName 管理员名
     * @param password 管理员密码
     * @return 管理员主页
     */
    @PostMapping("/login")
    public String login(String managerName, String password){
        // 用户密码MD5加密匹配
        password = Md5Util.code(password);
        Manager loginManager = managerService.login(managerName, password);
        if (loginManager != null) {
            log.info("登录成功！");
            RedisUtil redisUtil = new RedisUtil();
            // 用户登录持续时间为30 min
            redisUtil.setex("managerName",1800,loginManager.getManagerName());
            return "redirect:http://localhost:6001/toMessage";
        } else {
            RedisUtil redisUtil = new RedisUtil();
            // 状态码设置60s
            redisUtil.setex("status",60,"登录失败");
            return "redirect:http://localhost:6011/status";
        }
    }
}
