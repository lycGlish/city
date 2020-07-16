package com.lyc.city.manager.controller;

import com.lyc.city.bean.Manager;
import com.lyc.city.manager.service.ManagerService;
import com.lyc.city.utils.Md5Util;
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

    @GetMapping("/quitManager")
    public String quitUser(HttpServletRequest request) {
        // 获取当前session
        HttpSession session = request.getSession();
        // 移除manager
        session.removeAttribute("manager");

        return "redirect:http://localhost:6021/index";
    }

    @PostMapping("/login")
    public String login(String managerName, String password, HttpServletResponse response){
        // 用户密码MD5加密匹配
        password = Md5Util.code(password);
//        HttpSession session = request.getSession(true);
        Manager loginManager = managerService.login(managerName, password);
        if (loginManager != null) {
            log.info("登录成功！");
            Cookie cookie = new Cookie("managerName", loginManager.getManagerName());
            response.addCookie(cookie);
//            session.setAttribute("manager", loginManager);
            return "redirect:http://localhost:6001/toMessage";
        } else {
//            session.setAttribute("status", "登录失败");
            return "redirect:http://localhost:6011/status";
        }
    }
}
