package com.miles.wechat.event;

import com.miles.wechat.message.model.receive.ReceivedTextMessage;

/**
 * 接收到文本消息的事件
 *
 * @author miles
 */
public interface ReceiveTextMsgEvent extends Event<ReceivedTextMessage> {
}
