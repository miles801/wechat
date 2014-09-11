package com.miles.wechat.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author miles
 * @datetime 2014/5/6 1:41
 */
public class AccessToken extends GlobalCode {
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("expires_in")
    private long expiresIn;

    public AccessToken(String accessToken, long expire) {
        this.accessToken = accessToken;
        this.expiresIn = expire;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expire_in) {
        this.expiresIn = expire_in;
    }

}
