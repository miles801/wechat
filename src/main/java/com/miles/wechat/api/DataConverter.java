package com.miles.wechat.api;


import com.miles.wechat.message.model.receive.ReceivedMessage;
import com.miles.wechat.message.model.reply.ReplyMessage;

/**
 * 微信消息对象与业务对象之间的数据转换接口
 *
 * @author miles
 * @datetime 2014/5/25 11:05
 */
public interface DataConverter<T> {

    /**
     * 将从微信接收到的消息对象转换成业务对象
     *
     * @param receivedMessage 微信消息对象
     * @return 业务对象
     */
    T toEntity(ReceivedMessage receivedMessage);

    /**
     * 将实体类转换成发送消息对象
     *
     * @param entity 业务对象
     * @return SendMessage对象
     */
    ReplyMessage toSendMessage(T entity);
}
