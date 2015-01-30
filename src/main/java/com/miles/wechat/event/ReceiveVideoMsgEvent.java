package com.miles.wechat.event;

import com.miles.wechat.message.model.receive.ReceivedVideoMessage;

/**
 * 接收视频消息事件
 *
 * @author miles
 */
public interface ReceiveVideoMsgEvent extends Event<ReceivedVideoMessage> {
}
