package com.miles.wechat.event;

import com.miles.wechat.message.model.receive.ReceivedImageMessage;

/**
 * 接收到图片消息的事件
 *
 * @author miles
 */
public interface ReceiveImageMsgEvent extends Event<ReceivedImageMessage> {
}
