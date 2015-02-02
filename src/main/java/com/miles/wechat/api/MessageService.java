package com.miles.wechat.api;

/**
 * <p>消息接口，提供高级群发、分组群发、给指定粉丝列表发送消息的功能</p>
 * <p>这个接口具有次数限制，并不保证每次发送的内容都会被所有的粉丝收到</p>
 *
 * @author miles
 * @datetime 2014/5/21 1:50
 */
public interface MessageService {

    /**
     * 高级群发接口：给指定公众号的所有粉丝推送
     *
     * @param messageType 消息类型，参考MessageType
     * @param message     群发内容（json）
     */
    ResponseInfo sendAll(String messageType, String message);

    /**
     * 给粉丝组发送消息
     *
     * @param groupId     粉丝组id
     * @param messageType 消息类型,参考MessageType
     * @param message     消息
     * @return 响应结果
     */
    ResponseInfo sendToGroup(String groupId, String messageType, String message);

    /**
     * 给一组粉丝发送消息
     *
     * @param toUsers     粉丝id数组
     * @param messageType 消息类型，参考MessageType
     * @param message     消息
     * @return 响应结果
     */
    ResponseInfo sendToUsers(String[] toUsers, String messageType, String message);
}
