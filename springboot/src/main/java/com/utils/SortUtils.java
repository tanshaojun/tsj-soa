package com.utils;

import com.bean.Log;

import java.util.*;

public class SortUtils {
    public static   Map<String, Map<String, List<Log>>> sortMapByKey(Map<String, Map<String, List<Log>>> map) {
        if (map == null || map.isEmpty()) return null;
        Map<String, Map<String, List<Log>>> newMap = new HashMap<>(16);
        Iterator<Map.Entry<String, Map<String, List<Log>>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Map<String, List<Log>>> next = iterator.next();
            String key = next.getKey();
            Map<String, List<Log>> value = next.getValue();
            Map<String, List<Log>> sortMap1 = new TreeMap((a, b) -> -(a.toString().compareTo(b.toString())));
            sortMap1.putAll(value);
            newMap.put(key, sortMap1);
        }
        Map<String, Map<String, List<Log>>> sortMap = new TreeMap((a, b) -> -(a.toString().compareTo(b.toString())));
        sortMap.putAll(newMap);
        return sortMap;
    }
}
