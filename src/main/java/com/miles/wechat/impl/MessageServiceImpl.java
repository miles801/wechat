package com.miles.wechat.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.miles.wechat.api.MessageService;
import com.miles.wechat.api.ResponseInfo;
import com.miles.wechat.api.WeChatUrl;
import com.miles.wechat.core.RequestWrapper;
import com.miles.wechat.message.model.send.MessageType;
import com.miles.wechat.utils.GsonHelper;
import com.miles.wechat.utils.SimpleRequest;
import com.miles.wechat.utils.StringUtils;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;

/**
 * @author miles
 * @datetime 2014/5/21 9:57
 */
public class MessageServiceImpl implements MessageService {

    public static final String GROUP = "filter";
    public static final String MESSAGE_TYPE = "msgtype";

    @Override
    public ResponseInfo sendToGroup(String groupId, String messageType, String message) {
        //验证
        if (StringUtils.isEmpty(groupId)) {
            throw new IllegalArgumentException("群发消息时，没有指定组的ID!");
        }
        if (StringUtils.isEmpty(message)) {
            throw new IllegalArgumentException("群发消息时，没有指定消息的内容!");
        }
        if (messageType == null) {
            throw new IllegalArgumentException("群发消息时，没有指定消息类型!");
        }
        //组装消息
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(GROUP, GsonHelper.addElement("group_id", groupId));

        addMessageContent(jsonObject, messageType, message);
        //获得要发送的数据
        Gson gson = new Gson();
        String json = gson.toJson(jsonObject);
        String url = RequestWrapper.getUrl(WeChatUrl.SEND_TO_GROUP);
        return doJsonPost(json, url);
    }

    @Override
    public ResponseInfo sendToUsers(String[] toUsers, String messageType, String message) {
        //验证
        if (toUsers == null || toUsers.length < 1) {
            throw new IllegalArgumentException("群发消息时，没有指定接收人的openID列表!");
        }
        if (StringUtils.isEmpty(message)) {
            throw new IllegalArgumentException("群发消息时，没有指定消息的内容!");
        }
        if (messageType == null) {
            throw new IllegalArgumentException("群发消息时，没有指定消息类型!");
        }
        //组装消息
        JsonObject jsonObject = new JsonObject();
        JsonArray array = new JsonArray();
        for (String user : toUsers) {
            array.add(new JsonPrimitive(user));
        }
        jsonObject.add("touser", array);

        addMessageContent(jsonObject, messageType, message);
        //获得要发送的数据
        Gson gson = new Gson();
        String json = gson.toJson(jsonObject);
        String url = RequestWrapper.getUrl(WeChatUrl.SEND_TO_USER);
        return doJsonPost(json, url);
    }

    private ResponseInfo doJsonPost(String json, String url) {
        StringEntity entity = null;
        try {
            entity = new StringEntity(json, "application/json", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //发送
        String result = SimpleRequest.doPost(url, entity);
        return RequestWrapper.getResponseInfo(result);
    }

    @Override
    public ResponseInfo sendAll(String messageType, String message) {
        //组装消息
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(GROUP, GsonHelper.addElement("is_to_all", true));
        addMessageContent(jsonObject, messageType, message);

        Gson gson = new Gson();
        java.lang.String json = gson.toJson(jsonObject);
        java.lang.String url = RequestWrapper.getUrl(WeChatUrl.SEND_TO_GROUP);
        return doJsonPost(json, url);
    }


    /**
     * 根据消息类型、消息主体将其封装到指定的JsonObject对象中
     */
    private void addMessageContent(JsonObject jsonObject, String messageType, String message) {
        if (MessageType.NEWS.equals(messageType)) {//图文消息
            jsonObject.add("mpnews", GsonHelper.addElement("media_id", message));
            jsonObject.addProperty(MESSAGE_TYPE, "mpnews");
        } else if (MessageType.TEXT.equals(messageType)) {//文本消息
            jsonObject.add("text", GsonHelper.addElement("content", message));
            jsonObject.addProperty(MESSAGE_TYPE, "text");
        } else if (MessageType.VOICE.equals(messageType)) {//语音消息
            jsonObject.add("voice", GsonHelper.addElement("media_id", message));
            jsonObject.addProperty(MESSAGE_TYPE, "voice");
        } else if (MessageType.VIDEO.equals(messageType)) {//视频消息
            jsonObject.add("mpvideo", GsonHelper.addElement("media_id", message));
            jsonObject.addProperty(MESSAGE_TYPE, "mpvideo");
        } else if (MessageType.IMAGE.equals(messageType)) {//图片消息
            jsonObject.add("image", GsonHelper.addElement("media_id", message));
            jsonObject.addProperty(MESSAGE_TYPE, "image");
        }
    }
}
