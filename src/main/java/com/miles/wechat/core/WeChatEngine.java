package com.miles.wechat.core;

import com.miles.wechat.api.*;
import com.miles.wechat.event.*;

/**
 * 微信的服务引擎，提供微信封装接口的实现
 *
 * @author miles
 * @datetime 2014/5/21 1:11
 */
public class WeChatEngine {
    private static WeChatEngine beans = new WeChatEngine(ServiceLoader.newInstance());
    private ServiceLoader serviceLoader;


    private WeChatEngine(ServiceLoader serviceLoader) {
        this.serviceLoader = serviceLoader;
    }

    public static WeChatEngine newInstance() {
        return beans;
    }

    public BasicService getBasicService() {
        return serviceLoader.getBasicService();
    }

    public FansService getFansService() {
        return serviceLoader.getFansService();
    }

    public FansGroupService getFansGroupService() {
        return serviceLoader.getFansGroupService();
    }

    public MenuService getMenuService() {
        return serviceLoader.getMenuService();
    }

    public MessageService getMessageService() {
        return serviceLoader.getMessageService();
    }

    public WeChatContext getWeChatContext() {
        return serviceLoader.getWeChatContext();
    }

    public ReceiveTextMsgEvent getReceiveTextMsgEvent() {
        return serviceLoader.getReceiveTextMsgEvent();
    }

    public ReceiveImageMsgEvent getReceiveImageMsgEvent() {
        return serviceLoader.getReceiveImageMsgEvent();
    }

    public ReceiveVoiceMsgEvent getReceiveVoiceMsgEvent() {
        return serviceLoader.getReceiveVoiceMsgEvent();
    }

    public ReceiveVideoMsgEvent getReceiveVideoMsgEvent() {
        return serviceLoader.getReceiveVideoMsgEvent();
    }

    public ReceiveLocationMsgEvent getReceiveLocationMsgEvent() {
        return serviceLoader.getReceiveLocationMsgEvent();
    }

    public SubscribeEvent getSubscribeEvent() {
        return serviceLoader.getSubscribeEvent();
    }

    public UnsubscribeEvent getUnsubscribeEvent() {
        return serviceLoader.getUnsubscribeEvent();
    }

    public ReceiveLinkMsgEvent getReceiveLinkMsgEvent() {
        return serviceLoader.getReceiveLinkMsgEvent();
    }

    public ReportLocationEvent getReportLocationEvent() {
        return serviceLoader.getReportLocationEvent();
    }

    public MenuViewEvent getMenuViewEvent() {
        return serviceLoader.getMenuViewEvent();
    }

    public MenuClickEvent getMenuClickEvent() {
        return serviceLoader.getMenuClickEvent();
    }

    public MultiMediaService getMultiMediaService() {
        return serviceLoader.getMultiMediaService();
    }
}
