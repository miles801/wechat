package com.miles.wechat.event;

import com.miles.wechat.message.model.receive.ReceivedLocationMessage;

/**
 * 接收到地理位置消息事件
 *
 * @author miles
 */
public interface ReceiveLocationMsgEvent extends Event<ReceivedLocationMessage> {
}
