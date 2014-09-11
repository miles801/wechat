package com.miles.wechat.impl;

import com.miles.wechat.api.MenuService;
import com.miles.wechat.api.ResponseInfo;
import com.miles.wechat.core.ServiceLoader;
import com.miles.wechat.core.WeChatEngine;
import com.miles.wechat.entity.Menu;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MenuServiceImplTest {
    private MenuService menuService;

    @Before
    public void setUp() throws Exception {
        ServiceLoader serviceLoader = ServiceLoader.newInstance();
        serviceLoader.setWeChatContext(SimpleWeChatContext.getInstance());
        serviceLoader.setMenuService(new MenuServiceImpl());
        WeChatEngine engine = WeChatEngine.newInstance();
        menuService = engine.getMenuService();
    }

    @Test
    public void testCreateMenu() throws Exception {
        Assert.assertNotNull(menuService);
        List<Menu> menus = new ArrayList<Menu>();
        Menu menu1 = new Menu();
        menu1.setName("测试菜单");
        menu1.setActionType("view");
        menu1.setUrl("www.baidu.com");
        Menu subMenu1 = new Menu();
        subMenu1.setName("孩子菜单1");
        subMenu1.setActionType("click");
        subMenu1.setActionValue("你好");
        menu1.addChild(subMenu1);
        Menu subMenu2 = new Menu();
        subMenu2.setName("孩子菜单2");
        subMenu2.setActionType("view");
        subMenu2.setUrl("www.iteye.com");
        menu1.addChild(subMenu2);
        menus.add(menu1);

        Menu menu2 = new Menu();
        menu2.setName("测试菜单2");
        menu2.setActionType("click");
        menu2.setActionValue("xxxx");
        menus.add(menu2);
        ResponseInfo responseInfo = menuService.createMenu(menus);
        if (!responseInfo.isSuccess()) {
            System.out.println(responseInfo.getInfo().getErrorCode());
            System.out.println(responseInfo.getInfo().getErrorMessage());
        }
        Assert.assertNotNull(responseInfo);
        Assert.assertTrue(responseInfo.isSuccess());
    }

    @Test
    public void testMenuList() throws Exception {
        List<Menu> menus = menuService.menuList();
        Assert.assertNotNull(menus);
        Assert.assertTrue(menus.size() > 0);
    }

    @Test
    public void testClearMenu() throws Exception {
        ResponseInfo responseInfo = menuService.clearMenu();
        Assert.assertNotNull(responseInfo);
        if (!responseInfo.isSuccess()) {
            System.out.println(responseInfo.getInfo().getErrorCode());
            System.out.println(responseInfo.getInfo().getErrorMessage());
        }
        Assert.assertTrue(responseInfo.isSuccess());
    }

}