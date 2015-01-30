package com.miles.wechat.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信菜单类
 *
 * @author miles
 */
public class Menu {
    private String name;
    /**
     * 动作类型
     */
    @SerializedName("type")
    private String actionType;
    /**
     * 菜单要执行的动作
     */
    @SerializedName("key")
    private String actionValue;
    @SerializedName("sub_button")
    private List<Menu> children;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionValue() {
        return actionValue;
    }

    public void setActionValue(String actionValue) {
        this.actionValue = actionValue;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void addChild(Menu menu) {
        if (children == null) {
            children = new ArrayList<Menu>();
        }
        children.add(menu);
    }
}
