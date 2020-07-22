package com.lyc.city.status.controller;

import com.lyc.city.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lyc
 * @date 2020/7/15 15:12
 */
@Controller
@Slf4j
@CrossOrigin
public class StatusConsumerController {

    @GetMapping("/status")
    public String status(Model model){
        String status = RedisUtil.get("status");
        model.addAttribute("status",status);
        return "status";
    }
}
