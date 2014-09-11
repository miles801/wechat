package com.miles.wechat.api;

import com.miles.wechat.entity.Menu;

import java.util.List;

/**
 * 微信数据与系统数据之间数据转换的适配器
 *
 * @author miles
 * @datetime 2014/5/15 15:11
 */
public interface AbstractMenuAdapter {
    /**
     * 将微信发送过来的json数据转换成系统能够识别的菜单集合
     *
     * @param wcMenuJson
     * @return
     */
    public List<Menu> deserialize(String wcMenuJson);

    /**
     * 将系统中的菜单集合转成json数据发送给微信
     *
     * @param menus
     * @return
     */
    public String serialize(List<Menu> menus);
}
