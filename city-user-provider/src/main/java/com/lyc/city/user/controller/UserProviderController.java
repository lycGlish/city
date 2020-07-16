package com.lyc.city.user.controller;

import com.lyc.city.bean.User;
import com.lyc.city.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lyc
 * @date 2020/7/15 15:36
 */
@RestController
@Slf4j
@CrossOrigin
public class UserProviderController {

    @Resource
    private UserService userService;

    @GetMapping("/deleteUserByUserId")
    public void deleteUserByUserId(@RequestParam("userId") Integer userId){
        Integer result = userService.deleteUserByUserId(userId);
        if(result!=0){
            log.info("删除用户成功！");
        }else {
            log.error("删除用户失败！");
        }
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}
