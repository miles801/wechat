package com.miles.wechat.entity;

/**
 * 微信粉丝分组
 *
 * @author miles
 * @datetime 2014/5/21 20:38
 */
public class FansGroup {
    private Integer id;
    private String name;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
