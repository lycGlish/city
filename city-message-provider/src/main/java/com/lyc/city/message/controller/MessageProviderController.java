package com.lyc.city.message.controller;

import com.lyc.city.bean.Message;
import com.lyc.city.message.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 9:34
 */
@RestController
@Slf4j
@CrossOrigin
public class MessageProviderController {

    @Resource
    private MessageService messageService;

    @PostMapping("/updateMessageByMessageId")
    public void updateMessageByMessageId(@RequestParam("modal_result") String result,
                                         @RequestParam("modal_messageId") Integer messageId){
        Message message = new Message();
        message.setMessageId(messageId);
        message.setResult(result);
        message.setMessageDescription("人工修改");
        // 注册时记录系统时间
        Date date = new Date();
        message.setCreateTime(date);
        int backResult = messageService.updateMessageByMessageId(message);
        if(backResult==0){
            log.error("消息修改失败！");
        }
    }

    @GetMapping("/deleteMessageByMessageId")
    public void deleteMessageByMessageId(@RequestParam("messageId") Integer messageId){
        Integer result = messageService.deleteMessageByMessageId(messageId);
        if (result == 0) {
            log.error("删除消息失败！");
        }
    }

    @GetMapping("/getDangerMessage")
    public List<Message> getDangerMessage(){
        return messageService.getDangerMessage();
    }

    @GetMapping("/getAllMessage")
    public List<Message> getAllMessage(){
        return messageService.getAllMessage();
    }

    @PostMapping("/uploadMessage")
    public Integer uploadMessage(@RequestBody Message message) {
        return messageService.uploadMessage(message);
    }
}
