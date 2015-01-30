package com.miles.wechat.event;

import com.miles.wechat.message.model.receive.EventUnsubscribeMessage;

/**
 * 粉丝取消关注的事件
 *
 * @author miles
 */
public interface UnsubscribeEvent extends Event<EventUnsubscribeMessage> {
}
