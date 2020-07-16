package com.lyc.city.message.service;

import com.lyc.city.bean.Message;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 9:56
 */
public interface MessageService {

    List<Message> getDangerMessage();

    List<Message> getAllMessage();

    Integer uploadMessage(Message message);

    Integer deleteMessageByMessageId(Integer messageId);

    Integer updateMessageByMessageId(Message message);
}
