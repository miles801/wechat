package com.miles.wechat.core;

import com.miles.wechat.api.*;
import com.miles.wechat.event.*;
import com.miles.wechat.impl.*;

/**
 * 初始化微信的配置服务
 *
 * @author miles
 * @datetime 2014/5/21 17:10
 */
public class ServiceLoader {
    private static ServiceLoader serviceLoader = new ServiceLoader();
    private String url;

    //service
    private BasicService basicService;
    private MenuService menuService;
    private MessageService messageService;
    private FansService fansService;
    private FansGroupService fansGroupService;
    private MultiMediaService multiMediaService;

    //context
    private WeChatContext weChatContext;

    //event
    private ReceiveTextMsgEvent receiveTextMsgEvent;
    private ReceiveImageMsgEvent receiveImageMsgEvent;
    private ReceiveVoiceMsgEvent receiveVoiceMsgEvent;
    private ReceiveVideoMsgEvent receiveVideoMsgEvent;
    private ReceiveLocationMsgEvent receiveLocationMsgEvent;
    private SubscribeEvent subscribeEvent;
    private UnsubscribeEvent unsubscribeEvent;
    private ReceiveLinkMsgEvent receiveLinkMsgEvent;
    private ReportLocationEvent reportLocationEvent;
    private MenuViewEvent menuViewEvent;
    private MenuClickEvent menuClickEvent;

    private TokenPolicy tokenPolicy;
    private ServiceLoader() {
        this.basicService = new BasicServiceImpl();
        this.menuService = new MenuServiceImpl();
        this.messageService = new MessageServiceImpl();
        this.fansService = new FansServiceImpl();
        this.fansGroupService = new FansGroupServiceImpl();
        this.multiMediaService = new MultiMediaServiceImpl();
    }

    public static ServiceLoader newInstance() {
        return serviceLoader;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BasicService getBasicService() {
        return basicService;
    }

    public void setBasicService(BasicService basicService) {
        this.basicService = basicService;
    }

    public MenuService getMenuService() {
        return menuService;
    }

    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public FansService getFansService() {
        return fansService;
    }

    public void setFansService(FansService fansService) {
        this.fansService = fansService;
    }

    public FansGroupService getFansGroupService() {
        return fansGroupService;
    }

    public void setFansGroupService(FansGroupService fansGroupService) {
        this.fansGroupService = fansGroupService;
    }

    public WeChatContext getWeChatContext() {
        return weChatContext;
    }

    public void setWeChatContext(WeChatContext weChatContext) {
        this.weChatContext = weChatContext;
    }

    public ReceiveTextMsgEvent getReceiveTextMsgEvent() {
        return receiveTextMsgEvent;
    }

    public void setReceiveTextMsgEvent(ReceiveTextMsgEvent receiveTextMsgEvent) {
        this.receiveTextMsgEvent = receiveTextMsgEvent;
    }

    public ReceiveImageMsgEvent getReceiveImageMsgEvent() {
        return receiveImageMsgEvent;
    }

    public void setReceiveImageMsgEvent(ReceiveImageMsgEvent receiveImageMsgEvent) {
        this.receiveImageMsgEvent = receiveImageMsgEvent;
    }

    public ReceiveVoiceMsgEvent getReceiveVoiceMsgEvent() {
        return receiveVoiceMsgEvent;
    }

    public void setReceiveVoiceMsgEvent(ReceiveVoiceMsgEvent receiveVoiceMsgEvent) {
        this.receiveVoiceMsgEvent = receiveVoiceMsgEvent;
    }

    public ReceiveVideoMsgEvent getReceiveVideoMsgEvent() {
        return receiveVideoMsgEvent;
    }

    public void setReceiveVideoMsgEvent(ReceiveVideoMsgEvent receiveVideoMsgEvent) {
        this.receiveVideoMsgEvent = receiveVideoMsgEvent;
    }

    public ReceiveLocationMsgEvent getReceiveLocationMsgEvent() {
        return receiveLocationMsgEvent;
    }

    public void setReceiveLocationMsgEvent(ReceiveLocationMsgEvent receiveLocationMsgEvent) {
        this.receiveLocationMsgEvent = receiveLocationMsgEvent;
    }

    public SubscribeEvent getSubscribeEvent() {
        return subscribeEvent;
    }

    public void setSubscribeEvent(SubscribeEvent subscribeEvent) {
        this.subscribeEvent = subscribeEvent;
    }

    public UnsubscribeEvent getUnsubscribeEvent() {
        return unsubscribeEvent;
    }

    public void setUnsubscribeEvent(UnsubscribeEvent unsubscribeEvent) {
        this.unsubscribeEvent = unsubscribeEvent;
    }

    public ReceiveLinkMsgEvent getReceiveLinkMsgEvent() {
        return receiveLinkMsgEvent;
    }

    public void setReceiveLinkMsgEvent(ReceiveLinkMsgEvent receiveLinkMsgEvent) {
        this.receiveLinkMsgEvent = receiveLinkMsgEvent;
    }

    public ReportLocationEvent getReportLocationEvent() {
        return reportLocationEvent;
    }

    public void setReportLocationEvent(ReportLocationEvent reportLocationEvent) {
        this.reportLocationEvent = reportLocationEvent;
    }

    public MenuViewEvent getMenuViewEvent() {
        return menuViewEvent;
    }

    public void setMenuViewEvent(MenuViewEvent menuViewEvent) {
        this.menuViewEvent = menuViewEvent;
    }

    public MenuClickEvent getMenuClickEvent() {
        return menuClickEvent;
    }

    public void setMenuClickEvent(MenuClickEvent menuClickEvent) {
        this.menuClickEvent = menuClickEvent;
    }

    public MultiMediaService getMultiMediaService() {
        return multiMediaService;
    }

    public void setMultiMediaService(MultiMediaService multiMediaService) {
        this.multiMediaService = multiMediaService;
    }

    public void setTokenPolicy(TokenPolicy tokenPolicy) {
        this.tokenPolicy = tokenPolicy;
    }

    public TokenPolicy getTokenPolicy() {
        return tokenPolicy;
    }
}
