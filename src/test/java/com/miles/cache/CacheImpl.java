package com.miles.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael
 */
public class CacheImpl implements Cache<String> {
    @Override
    public Map<String, String> load() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        return map;
    }

    @Override
    public long getTimeout() {
        return 60 * 1000;
    }

    @Override
    public void doWhileTimeout() {
        System.out.println("超时了...");
    }

}
