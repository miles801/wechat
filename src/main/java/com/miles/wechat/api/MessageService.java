package com.miles.wechat.api;

/**
 * @author miles
 * @datetime 2014/5/21 1:50
 */
public interface MessageService {

    /**
     * 给粉丝组发送消息
     *
     * @param groupId     粉丝组id
     * @param messageType 消息类型
     * @param message     消息
     * @return 响应结果
     */
    ResponseInfo sendToGroup(String groupId, MessageType messageType, String message);

    /**
     * 给一组粉丝发送消息
     *
     * @param toUsers     粉丝id数组
     * @param messageType 消息类型
     * @param message     消息
     * @return 响应结果
     */
    ResponseInfo sendToUsers(String[] toUsers, MessageType messageType, String message);
}
