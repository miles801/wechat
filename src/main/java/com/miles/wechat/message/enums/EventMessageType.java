package com.miles.wechat.message.enums;

/**
 * 事件消息的类型
 *
 * @author Michael
 */
public enum EventMessageType {
    /**
     * 关注（可能包含关注与扫描两种可能）
     */
    SUBSCRIBE("subscribe"),
    /**
     * 取消关注
     */
    UNSUBSCRIBE("unsubscribe"),
    /**
     * 扫描二维码事件
     */
    SCAN("SCAN"),
    /**
     * 地理位置
     */
    LOCATION("LOCATION"),
    /**
     * 点击菜单：关键字
     */
    MENU_CLICK("CLICK"),
    /**
     * 点击菜单：链接
     */
    MENU_LINK("VIEW");

    private String value;

    private EventMessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
