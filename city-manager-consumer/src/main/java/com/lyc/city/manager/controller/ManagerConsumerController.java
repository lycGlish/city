package com.lyc.city.manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/toPosition")
    public String toPosition() {
        return "position";
    }

    @GetMapping("/toCamera")
    public String toCamera() {
        return "camera";
    }

    @GetMapping("/toUploadCamera")
    public String toUploadCamera() {
        return "uploadCamera";
    }

    @GetMapping("/toUserImage")
    public String toUserImage() {
        return "userImage";
    }

    @GetMapping("/toCameraImage")
    public String toCameraImage() {
        return "cameraImage";
    }

    @GetMapping("/toMessage")
    public String toMessage() {
        return "message";
    }

    @GetMapping("/toUserList")
    public String toUserList() {
        return "userList";
    }
}
