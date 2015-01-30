package com.miles.wechat.core;

import com.miles.cache.CacheContainer;
import com.miles.wechat.api.*;
import com.miles.wechat.event.*;
import com.miles.wechat.exceptions.WeChatConfigException;
import org.apache.log4j.Logger;

/**
 * 微信的服务引擎，提供微信封装接口的实现
 *
 * @author miles
 */
public class WeChatEngine {
    /**
     * 初始化：并加载事件处理器
     */
    private static WeChatEngine engine = new WeChatEngine(EventHandler.getInstance());

    // 初始化内置服务接口的实例
    private ServiceLoader serviceLoader;

    // 初始化对外暴露的接口的实例
    private PublicServiceLoader publicServiceLoader;

    private EventHandler eventHandler;
    private Logger logger = Logger.getLogger(WeChatEngine.class);


    private WeChatEngine(EventHandler eventHandler) {
        // 注册事件处理器
        this.eventHandler = eventHandler;
        logger.info("WechatEngine:注册事件处理器...");

        // 注册微信引擎内置服务
        logger.info("WechatEngine:注册引擎内置服务...");
        serviceLoader = ServiceLoader.newInstance();


        CacheContainer cacheContainer = CacheContainer.getInstance();
        // 注册AccessToken缓存
        logger.info("WechatEngine:注册AccessToken缓存...");
        cacheContainer.register(CacheAccessToken.class, new CacheAccessToken());

        logger.info("WechatEngine：注册引擎对外接口的实例...");
        publicServiceLoader = PublicServiceLoader.getInstance();

        // 注册账号缓存
        logger.info("WechatEngine:注册账号缓存...");
        CacheAccount cacheAccount = publicServiceLoader.getCacheAccount();
        if (cacheAccount == null) {
            throw new WeChatConfigException("初始化微信引擎失败!没有获得" + CacheAccount.class.getName() + "接口的实例!");
        }
        cacheContainer.register(CacheAccount.class, cacheAccount);
    }

    public static WeChatEngine newInstance() {
        return engine;
    }

    /**
     * 获得认证服务接口
     */
    public AuthService getAuthService() {
        return serviceLoader.getAuthService();
    }

    /**
     * 获得粉丝处理接口
     */
    public FansService getFansService() {
        return serviceLoader.getFansService();
    }

    /**
     * 获得粉丝组处理接口
     */
    public FansGroupService getFansGroupService() {
        return serviceLoader.getFansGroupService();
    }

    /**
     * 获得微信菜单操作接口
     */
    public MenuService getMenuService() {
        return serviceLoader.getMenuService();
    }

    /**
     * 获得微信主动发送消息的操作接口
     */
    public MessageService getMessageService() {
        return serviceLoader.getMessageService();
    }

    /**
     * 获得微信多媒体接口
     */
    public MultiMediaService getMultiMediaService() {
        return serviceLoader.getMultiMediaService();
    }

    /**
     * 获得接收文本消息时的事件处理器（通过EventHandler进行注册）
     */
    public ReceiveTextMsgEvent getReceiveTextMsgEvent() {
        return eventHandler.getReceiveTextMsgEvent();
    }

    /**
     * 获得接收图片消息时的事件处理器（通过EventHandler进行注册）
     */
    public ReceiveImageMsgEvent getReceiveImageMsgEvent() {
        return eventHandler.getReceiveImageMsgEvent();
    }


    /**
     * 获得接收语音消息时的事件处理器（通过EventHandler进行注册）
     */
    public ReceiveVoiceMsgEvent getReceiveVoiceMsgEvent() {
        return eventHandler.getReceiveVoiceMsgEvent();
    }


    /**
     * 获得接收视频消息时的事件处理器（通过EventHandler进行注册）
     */
    public ReceiveVideoMsgEvent getReceiveVideoMsgEvent() {
        return eventHandler.getReceiveVideoMsgEvent();
    }


    /**
     * 获得地理位置息时的事件处理器（通过EventHandler进行注册）
     */
    public ReceiveLocationMsgEvent getReceiveLocationMsgEvent() {
        return eventHandler.getReceiveLocationMsgEvent();
    }


    /**
     * 获得粉丝关注时的事件处理器（通过EventHandler进行注册）
     */
    public SubscribeEvent getSubscribeEvent() {
        return eventHandler.getSubscribeEvent();
    }

    /**
     * 获得粉丝取消关注时的事件处理器（通过EventHandler进行注册）
     */
    public UnsubscribeEvent getUnsubscribeEvent() {
        return eventHandler.getUnsubscribeEvent();
    }


    /**
     * 获得粉接收链接消息时的事件处理器（通过EventHandler进行注册）
     */
    public ReceiveLinkMsgEvent getReceiveLinkMsgEvent() {
        return eventHandler.getReceiveLinkMsgEvent();
    }


    /**
     * 获得粉接发送地理位置报告消息时的事件处理器（通过EventHandler进行注册）
     */
    public ReportLocationEvent getReportLocationEvent() {
        return eventHandler.getReportLocationEvent();
    }


    /**
     * 获得粉丝点击菜单链接时的事件处理器（通过EventHandler进行注册）
     */
    public MenuViewEvent getMenuViewEvent() {
        return eventHandler.getMenuViewEvent();
    }


    /**
     * 获得粉接菜单按钮时的事件处理器（通过EventHandler进行注册）
     */
    public MenuClickEvent getMenuClickEvent() {
        return eventHandler.getMenuClickEvent();
    }

}
