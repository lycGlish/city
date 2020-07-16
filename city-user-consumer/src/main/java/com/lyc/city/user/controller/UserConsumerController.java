package com.lyc.city.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lyc
 * @date 2020/7/15 11:44
 */
@Controller
@Slf4j
@CrossOrigin
public class UserConsumerController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
