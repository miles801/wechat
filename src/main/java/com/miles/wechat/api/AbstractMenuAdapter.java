package com.miles.wechat.api;

import com.miles.wechat.entity.Menu;

import java.util.List;

/**
 * <p>
 * 微信数据与系统数据之间数据转换的适配器，提供：<br/>
 * 1、将菜单集合转成微信公众平台能够识别的json字符串<br/>
 * 2、将微信公众平台发送过来的菜单json字符串转成菜单集合
 * </p>
 *
 * @author miles
 */
public interface AbstractMenuAdapter {
    /**
     * 将微信发送过来的json数据转换成系统能够识别的菜单集合
     *
     * @param wcMenuJson 微信发送过来的菜单json数据
     */
    public List<Menu> deserialize(String wcMenuJson);

    /**
     * 将系统中的菜单集合转成json数据发送给微信
     *
     * @param menus 菜单集合
     * @return 即将推送给微信的菜单json字符串
     */
    public String serialize(List<Menu> menus);
}
