package com.lyc.city.message.dao;

import com.lyc.city.bean.Message;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 10:52
 */
public interface MessageMapper {

    List<Message> selectDangerMessage();

    List<Message> selectAllMessage();

    Integer insertMessage(Message message);

    Integer deleteMessageByMessageId(Integer messageId);

    Integer updateMessageByMessageId(Message message);
}
