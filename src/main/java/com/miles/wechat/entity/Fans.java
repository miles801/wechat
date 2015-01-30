package com.miles.wechat.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 粉丝
 *
 * @author miles
 * @datetime 2014/5/21 16:52
 */
public class Fans {
    /**
     * 关注（0表示否，1表示是）
     */
    private Integer subscribe;
    @SerializedName("openid")
    private String openId;
    private String nickname;
    private Integer sex;
    private String language;
    private String city;
    private String province;
    private String country;
    @SerializedName("headimgurl")
    private String headImgUrl;
    /**
     * 关注时间
     */
    @SerializedName("subscribe_time")
    private Long subscribeTime;

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Long getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Long subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
