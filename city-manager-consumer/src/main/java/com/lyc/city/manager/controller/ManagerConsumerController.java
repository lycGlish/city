package com.lyc.city.manager.controller;

import com.lyc.city.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lyc
 * @date 2020/7/15 14:54
 */
@Controller
@Slf4j
@CrossOrigin
public class ManagerConsumerController {

    /**
     * 跳转位置页面
     * @param model
     * @return
     */
    @GetMapping("/toPosition")
    public String toPosition(Model model) {
        String managerName = RedisUtil.get("managerName");
        if (managerName != null) {
            model.addAttribute("managerName", managerName);
            return "position";
        }else {
            RedisUtil redisUtil = new RedisUtil();
            // 状态码设置60s
            redisUtil.setex("status",60,"未登录");
            return "redirect:http://localhost:6011/status";
        }
    }

    /**
     * 跳转摄像头页面
     * @param model
     * @return
     */
    @GetMapping("/toCamera")
    public String toCamera(Model model) {
        String managerName = RedisUtil.get("managerName");
        if (managerName != null) {
            model.addAttribute("managerName", managerName);
            return "camera";
        }else {
            RedisUtil redisUtil = new RedisUtil();
            // 状态码设置60s
            redisUtil.setex("status",60,"未登录");
            return "redirect:http://localhost:6011/status";
        }
    }

    /**
     * 跳转上传摄像头页面
     * @param model
     * @return
     */
    @GetMapping("/toUploadCamera")
    public String toUploadCamera(Model model) {
        String managerName = RedisUtil.get("managerName");
        if (managerName != null) {
            model.addAttribute("managerName", managerName);
            return "uploadCamera";
        }else {
            RedisUtil redisUtil = new RedisUtil();
            // 状态码设置60s
            redisUtil.setex("status",60,"未登录");
            return "redirect:http://localhost:6011/status";
        }
    }

    /**
     * 跳转用户图片页面
     * @param model
     * @return
     */
    @GetMapping("/toUserImage")
    public String toUserImage(Model model) {
        String managerName = RedisUtil.get("managerName");
        if (managerName != null) {
            model.addAttribute("managerName", managerName);
            return "userImage";
        }else {
            RedisUtil redisUtil = new RedisUtil();
            // 状态码设置60s
            redisUtil.setex("status",60,"未登录");
            return "redirect:http://localhost:6011/status";
        }
    }

    /**
     * 跳转摄像头图片页面
     * @param model
     * @return
     */
    @GetMapping("/toCameraImage")
    public String toCameraImage(Model model) {
        String managerName = RedisUtil.get("managerName");
        if (managerName != null) {
            model.addAttribute("managerName", managerName);
            return "cameraImage";
        }else {
            RedisUtil redisUtil = new RedisUtil();
            // 状态码设置60s
            redisUtil.setex("status",60,"未登录");
            return "redirect:http://localhost:6011/status";
        }
    }

    /**
     * 跳转消息页面
     * @param model
     * @return
     */
    @GetMapping("/toMessage")
    public String toMessage(Model model) {
        String managerName = RedisUtil.get("managerName");
        if (managerName != null) {
            model.addAttribute("managerName", managerName);
            return "message";
        }else {
            RedisUtil redisUtil = new RedisUtil();
            // 状态码设置60s
            redisUtil.setex("status",60,"未登录");
            return "redirect:http://localhost:6011/status";
        }
    }

    /**
     * 跳转用户列表页面
     * @param model
     * @return
     */
    @GetMapping("/toUserList")
    public String toUserList(Model model) {
        String managerName = RedisUtil.get("managerName");
        if (managerName != null) {
            model.addAttribute("managerName", managerName);
            return "userList";
        }else {
            RedisUtil redisUtil = new RedisUtil();
            // 状态码设置60s
            redisUtil.setex("status",60,"未登录");
            return "redirect:http://localhost:6011/status";
        }
    }
}
