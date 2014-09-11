package com.miles.wechat.api;

import com.miles.wechat.entity.message.ReceiveMessage;
import com.miles.wechat.entity.message.SendMessage;

/**
 * @author miles
 * @datetime 2014/5/22 6:55
 */
public interface ResponseService {
    SendMessage receiveTextMsg(ReceiveMessage message);

    SendMessage receiveImageMsg(ReceiveMessage message);

    SendMessage receiveVoiceMsg(ReceiveMessage message);

    SendMessage receiveVideoMsg(ReceiveMessage message);

    SendMessage receiveLocationMsg(ReceiveMessage message);

    SendMessage onSubscribe(ReceiveMessage message);

    SendMessage onUnsubscribe(ReceiveMessage message);
}
