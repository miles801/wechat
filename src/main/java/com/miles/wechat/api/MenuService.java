package com.miles.wechat.api;

import com.miles.wechat.entity.Menu;

import java.util.List;

/**
 * @author miles
 * @datetime 2014/5/21 1:50
 */
public interface MenuService {

    /**
     * 创建菜单
     *
     * @param menus 菜单列表
     * @return 响应结果
     */
    ResponseInfo createMenu(List<Menu> menus);

    /**
     * 清空菜单
     *
     * @return 响应结果
     */
    ResponseInfo clearMenu();

    /**
     * 获得菜单列表
     *
     * @return 菜单列表
     */
    List<Menu> menuList();
}
