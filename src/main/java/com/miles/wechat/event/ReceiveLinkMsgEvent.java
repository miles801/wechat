package com.miles.wechat.event;

import com.miles.wechat.message.model.receive.ReceivedLinkMessage;

/**
 * 接收到链接消息
 *
 * @author miles
 */
public interface ReceiveLinkMsgEvent extends Event<ReceivedLinkMessage> {
}
