package com.miles.wechat.event;

import com.miles.wechat.message.model.receive.EventMenuLinkMessage;

/**
 * 点击链接菜单的事件
 *
 * @author miles
 */
public interface MenuViewEvent extends Event<EventMenuLinkMessage> {
}
