package com.simba.framework.util.python;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linshuo on 2018/4/19.
 */
public class PythonCache {
    private static final Map<String, Class<?>> pythonClassCache = new HashMap<String, Class<?>>();

    private PythonCache() {
    }

    private static class PythonCacheHolder {
        private static final PythonCache instance = new PythonCache();
    }

    public static PythonCache getInstance() {
        return PythonCacheHolder.instance;
    }

    public Class<?> getClassByKey(String key) {
        return pythonClassCache.get(key);
    }

    public void putClass(String key, Class<?> clazz) {
        pythonClassCache.put(key, clazz);
    }

    public boolean containsClassKey(String key) {
        return pythonClassCache.containsKey(key);
    }

}
