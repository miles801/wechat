package com.miles.wechat.event;

import com.miles.wechat.message.model.receive.ReceivedMessage;
import com.miles.wechat.message.model.reply.ReplyMessage;

/**
 * <p>
 * 微信核心接口，当微信post数据到本地服务器时，将会触发一个事件
 * </p>
 * <p>
 * 通过实现该接口来处理接收到的数据并进行回复的功能
 * </p>
 * R:具体的消息类型
 *
 * @author miles
 */
public interface Event<R extends ReceivedMessage> {
    /**
     * @param receivedMessage 接收到的消息对象
     * @return 要回复给微信的数据
     */
    ReplyMessage execute(R receivedMessage);
}
