package com.miles.wechat.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Gson的辅助工具类
 *
 * @author miles
 */
public class GsonHelper {

    /**
     * 根据key和值生成一个JsonObject对象
     */
    public static JsonObject addElement(String key, String value) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(key, value);
        return jsonObject;
    }
    
    public static JsonObject addElement(String key, Boolean value) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(key, value);
        return jsonObject;
    }

    /**
     * 将一个对象转成json字符串
     *
     * @param obj 要被转化的对象
     * @return json字符串
     */
    public static String toJson(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("要被转成json字符串的对象不能为空!");
        }
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * 将json字符串转换为java对象
     *
     * @param json  json字符串
     * @param clazz 类型
     * @param <T>   泛型
     * @return java对象
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            throw new IllegalArgumentException("将json字符串转成bean时，json字符串不能为空!");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("将json字符串转成bean时，bean的类型不能为空");
        }
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }
}
