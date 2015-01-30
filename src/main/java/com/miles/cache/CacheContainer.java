package com.miles.cache;

import java.util.*;

/**
 * <p>
 * 缓存管理器，一个缓存管理器可以拥有多个缓存的对象
 * </p>
 * <p>
 * 每一个缓存对象都有一个超时时间和加载数据的方法
 * </p>
 * <p>
 * 当注册缓存后，每隔一段时间，缓存管理器就会去检查时候有缓存过期，如果过期，则将其从缓存池中移除（以释放内存）；
 * 也就是说，当一个缓存真正到达过期时间时，并不会立即就被清空缓存，而是需要等待缓存管理器来回收处理
 * </p>
 * <p>
 * 当获取某一个缓存的数据时，会首先检查该缓存是否已经被移除，如果已经移除，则重新加载数据到缓存中，同时注册缓存时间；
 * 如果该缓存数据存在，则直接返回数据
 * </p>
 * <p>
 * 当移除某个缓存时，只会移除其缓存的数据，而不会移除其注册信息
 * </p>
 * <p>注意：以后应该要注意到并发的情况!</p>
 *
 * @author Michael
 */
public class CacheContainer {

    // 检查缓存是否过期的间隔时间（30秒）
    // 这个参数的值可以考虑通过配置文件的方式获取
    private static final Long TIMER_PERIOD = 30 * 1000l;

    private static CacheContainer cacheContainer = new CacheContainer();

    // 已注册的缓存对象
    private Map<String, Cache> registeredCache = new HashMap<String, Cache>();

    // 缓存数据对象,真正保存数据的地方
    private Map<String, Map<String, Object>> data = new HashMap<String, Map<String, Object>>();


    // 用户保存缓存的过期时间
    // 当指定key的数据被清除或者重新加载时，刷新对应的过期时间
    private Map<String, Long> registerDate = new HashMap<String, Long>();

    // 用于保存被移除的缓存
    private Set<String> removedCache = new HashSet<String>();


    private CacheContainer() {
        // 定时清空缓存
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long now = new Date().getTime();
                Set<Map.Entry<String, Long>> entrySet = registerDate.entrySet();
                for (Map.Entry<String, Long> entry : entrySet) {
                    if (now > entry.getValue()) {
                        data.remove(entry.getKey());// 移除指定缓存的数据（只是移除数据）
                        removedCache.add(entry.getKey());// 标识该缓存的数据已被移除
                        // 当超时时，触发事件
                        Cache cache = registeredCache.get(entry.getKey());

                        // 移除已注册的时间
                        registerDate.remove(entry.getKey());

                        cache.doWhileTimeout();
                    }
                }
            }
        }, 5000, TIMER_PERIOD);
    }

    public static CacheContainer getInstance() {
        return cacheContainer;
    }

    /**
     * 获得指定的一个缓存数据
     * 一般不建议修改返回的map中的数据（以后可能会返回一个只读的map）
     *
     * @param clazz 缓存类型
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getCachedData(Class<? extends Cache> clazz) {
        String key = clazz.getName();
        Map<String, Object> map = data.get(key);
        // 判断数据是否被移除
        if (map == null && removedCache.contains(key)) {
            Cache cache = registeredCache.get(key);
            // 重新加载数据
            map = cache.load();

            // 重新设置缓存失效的时间
            setTimeoutTime(cache, key);

            // 重置已删除缓存标识
            removedCache.remove(key);

            // 重新将缓存数据加入到缓存池中
            data.put(key, map);
        }
        return map;
    }

    /**
     * 注册缓存
     * 如果存在同名的缓存对象，则将抛出异常
     * 如果cache为null，则表示清空该缓存
     *
     * @param clazz 缓存类型
     * @param cache 缓存对象
     */
    public void register(Class<? extends Cache> clazz, Cache cache) {
        String key = clazz.getName();
        if (registeredCache.containsKey(key)) {
            throw new RuntimeException("Key为[" + key + "]的缓存对象已经被注册!");
        }

        // 注册过期时间
        setTimeoutTime(cache, key);

        // 注册缓存
        registeredCache.put(key, cache);

        // 将缓存标识加入到已移除队列中，可以实现延迟加载的功能
        removedCache.add(key);
    }

    /**
     * 设置指定缓存的失效时间
     *
     * @param cache 缓存对象
     * @param key   缓存的标示符
     */
    private void setTimeoutTime(Cache cache, String key) {
        registerDate.remove(key);
        long timeout = cache.getTimeout();
        if (timeout > 0) {
            registerDate.put(key, new Date().getTime() + timeout);
        }
    }

    /**
     * 清空所有缓存的数据
     */
    public void clear() {
        // 清空所有缓存的数据
        data.clear();

        // 清空所有已注册缓存的失效时间
        registerDate.clear();

        // 将所有已注册的缓存的标识加入到已清除列表中
        removedCache.addAll(registeredCache.keySet());
    }

    /**
     * 将指定的缓存的数据从缓存池中移除
     *
     * @param clazz 缓存类型
     */
    public void remove(Class<? extends Cache> clazz) {
        String key = clazz.getName();
        // 删除数据
        data.remove(key);

        // 删除指定缓存的失效时间
        registerDate.remove(key);

        // 设置已清空缓存的标识
        removedCache.add(key);
    }

    /**
     * 给指定的缓存添加元素
     *
     * @param clazz     缓存类型
     * @param itemKey   元素的key
     * @param itemValue 元素的值
     */
    @SuppressWarnings("unchecked")
    public void addItem(Class<? extends Cache> clazz, String itemKey, Object itemValue) {
        String key = clazz.getName();
        Map<String, Object> map = data.get(key);
        if (map == null) {
            map = new HashMap<String, Object>();
            data.put(key, map);
        }
        map.put(itemKey, itemValue);
    }

    /**
     * 重新加载指定缓存的数据
     *
     * @param clazz 缓存类型
     */
    public void reload(Class<? extends Cache> clazz) {
        String key = clazz.getName();
        Cache cache = registeredCache.get(key);
        if (cache != null) {
            // 清空历史数据
            data.remove(key);
            // 重新加载数据
            Map<String, Object> map = cache.load();

            // 设置新的数据
            data.put(key, map);

            // 更新超时时间
            setTimeoutTime(cache, key);
        }
    }
}
