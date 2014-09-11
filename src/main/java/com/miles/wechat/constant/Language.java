package com.miles.wechat.constant;

/**
 * 语言
 * Created by miles on 2014/5/21.
 */
public enum Language {
    ZH_CN("zh_CN"),
    ZH_TW("zh_TW"),
    EN("en");
    private String value;

    private Language(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
