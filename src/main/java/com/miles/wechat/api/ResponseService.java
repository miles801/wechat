package com.miles.wechat.api;

import com.miles.wechat.message.model.receive.ReceivedMessage;
import com.miles.wechat.message.model.reply.ReplyMessage;

/**
 * @author miles
 * @datetime 2014/5/22 6:55
 */
public interface ResponseService {
    ReplyMessage receiveTextMsg(ReceivedMessage message);

    ReplyMessage receiveImageMsg(ReceivedMessage message);

    ReplyMessage receiveVoiceMsg(ReceivedMessage message);

    ReplyMessage receiveVideoMsg(ReceivedMessage message);

    ReplyMessage receiveLocationMsg(ReceivedMessage message);

    ReplyMessage onSubscribe(ReceivedMessage message);

    ReplyMessage onUnsubscribe(ReceivedMessage message);
}
