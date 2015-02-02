package com.miles.wechat.core;


import com.miles.wechat.api.*;
import com.miles.wechat.impl.*;

/**
 * 微信内置服务的加载器，不对外
 *
 * @author miles
 */
public class ServiceLoader {
    private static ServiceLoader serviceLoader = new ServiceLoader();

    // service（内置）
    private AuthService authService;
    private MenuService menuService;
    private MessageService messageService;
    private FansService fansService;
    private FansGroupService fansGroupService;
    private MultiMediaService multiMediaService;


    private ServiceLoader() {
        this.authService = new AuthServiceImpl();
        this.menuService = new MenuServiceImpl();
        this.messageService = new MessageServiceImpl();
        this.fansService = new FansServiceImpl();
        this.fansGroupService = new FansGroupServiceImpl();
        this.multiMediaService = new MultiMediaServiceImpl();
    }

    public static ServiceLoader newInstance() {
        return serviceLoader;
    }

    public AuthService getAuthService() {
        return authService;
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

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    public MultiMediaService getMultiMediaService() {
        return multiMediaService;
    }

    public void setMultiMediaService(MultiMediaService multiMediaService) {
        this.multiMediaService = multiMediaService;
    }
}
