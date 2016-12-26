package com.miles.wechat.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 微信客服
 *
 * @author Michael
 */
public class CustomerServer {
    @SerializedName("kf_account")
    private String account;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("password")
    private String password;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
