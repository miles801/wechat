package com.miles.wechat.utils;

import java.io.Serializable;

/**
 * 占位符格式化
 * 例如：https://api.weixin.qq.com/cgi-bin/menu/create?access_token=${1}
 *
 * @author miles
 * @datetime 2014/5/15 2:07
 */
public class PlaceholderFormat {
    /**
     * 格式化字符串
     *
     * @param src
     * @param data
     * @return
     */
    public static String format(String src, Serializable... data) {
        if (StringUtils.isEmpty(src)) {
            throw new IllegalArgumentException("要格式化的字符串不能为空!");
        }
        if (data == null || data.length < 1) return src;
        int index = 1;//从1开始搜索
        int cursor = 0;//当前游标
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < data.length; i++, index++) {
            int ind = src.indexOf("${" + index + "}", cursor);
            if (ind != -1) {
                int placeholderLength = 3 + (index + "").length();//占位符的长度
                //如果值为空串，则连同占位符前面的内容一起删除
                if (data[i] == null || StringUtils.isEmpty(data[i].toString())) {
                    int start = src.lastIndexOf("&", ind);
                    start = (start == -1 ? src.lastIndexOf("?", ind) : start);
                    if (start == -1) {
                        throw new RuntimeException("错误的URL地址!");
                    }
                } else {
                    buffer.append(src.substring(cursor, ind));
                    buffer.append(data[i]);
                }
                cursor = ind + placeholderLength;
            }
        }
        buffer.append(src.substring(cursor));
        return buffer.toString();
    }
}
