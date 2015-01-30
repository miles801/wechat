package com.miles.cache;

import java.util.Map;

/**
 * 缓存，每个缓存都包含若干组key-value
 * T:缓存的数据的类型
 *
 * @author Michael
 */
public interface Cache<T> {

    /**
     * 获得超时时间
     * 如果值小于0，则表示一直持有，不会超时
     *
     * @return 单位为毫秒
     */
    long getTimeout();

    /**
     * 加载需要缓存的数据
     */
    Map<String, T> load();

    /**
     * 当超时的时候需要做的事情
     */
    public void doWhileTimeout();
}
