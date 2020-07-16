package com.lyc.city.message.service.impl;

import com.lyc.city.bean.Message;
import com.lyc.city.message.dao.MessageMapper;
import com.lyc.city.message.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 9:56
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Override
    public List<Message> getDangerMessage() {
        return messageMapper.selectDangerMessage();
    }

    @Override
    public List<Message> getAllMessage() {
        return messageMapper.selectAllMessage();
    }

    @Override
    public Integer uploadMessage(Message message) {
        return messageMapper.insertMessage(message);
    }

    @Override
    public Integer deleteMessageByMessageId(Integer messageId) {
        return messageMapper.deleteMessageByMessageId(messageId);
    }

    @Override
    public Integer updateMessageByMessageId(Message message) {
        return messageMapper.updateMessageByMessageId(message);
    }
}
