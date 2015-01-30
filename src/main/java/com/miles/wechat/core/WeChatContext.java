package com.miles.wechat.core;

/**
 * @author Michael
 */
public class WeChatContext {
    private static ThreadLocal<String> _originalId = new ThreadLocal<String>();

    public static void set(String originalId) {
        _originalId.set(originalId);
    }

    public static void remove() {
        _originalId.remove();
    }

    public static String get() {
        return _originalId.get();
    }
}
