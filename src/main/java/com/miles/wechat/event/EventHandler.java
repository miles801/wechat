package com.miles.wechat.event;

/**
 * 事件处理机：对外提供，让用户自己指定实现类
 *
 * @author Michael
 */
public class EventHandler {

    private static EventHandler ourInstance = new EventHandler();

    public static EventHandler getInstance() {
        return ourInstance;
    }

    private EventHandler() {
    }

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

    public static EventHandler getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(EventHandler ourInstance) {
        EventHandler.ourInstance = ourInstance;
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
}
