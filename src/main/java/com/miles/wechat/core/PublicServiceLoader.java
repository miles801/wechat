package com.miles.wechat.core;

/**
 * 公共接口的实现类加载器，外部可见
 *
 * @author Michael
 */
public class PublicServiceLoader {
    private static PublicServiceLoader ourInstance = new PublicServiceLoader();

    public static PublicServiceLoader getInstance() {
        return ourInstance;
    }

    private PublicServiceLoader() {
    }

    /**
     * 账号缓存的接口：必须实现的
     */
    private CacheAccount cacheAccount;

    public CacheAccount getCacheAccount() {
        return cacheAccount;
    }

    public void setCacheAccount(CacheAccount cacheAccount) {
        this.cacheAccount = cacheAccount;
    }
}
