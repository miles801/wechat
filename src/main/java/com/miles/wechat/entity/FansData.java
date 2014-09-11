package com.miles.wechat.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author miles
 * @datetime 2014/5/21 18:07
 */
public class FansData {
    private int total;
    private int count;
    private List<String> data;
    @SerializedName("next_openid")
    private String nextOpenId;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public String getNextOpenId() {
        return nextOpenId;
    }

    public void setNextOpenId(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }
}
