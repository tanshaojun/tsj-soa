package com.other.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class findTheDifference {
    public static char findTheDifference(String s, String t) {
        char a = t.charAt(0);
        Map<String, Integer> map = new HashMap<>(16);
        Map<String, Integer> map1 = new HashMap<>(16);
        for (int i = 0; i < t.length(); i++) {
            aaaaaaa(t, map1, i);
            if (i <= s.length() - 1)
                aaaaaaa(s, map, i);
        }
        Iterator<Map.Entry<String, Integer>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String k = next.getKey();
            Integer value = next.getValue();
            Integer integer = map.get(k);
            if (!value.equals(integer)) {
                a = k.charAt(0);
                break;
            }
        }
        return a;
    }

    private static void aaaaaaa(String s, Map<String, Integer> map, int i) {
        String s2 = String.valueOf(s.charAt(i));
        if (map.get(s2) == null) {
            map.put(s2, 0);
        } else {
            Integer integer = map.get(s2);
            integer++;
            map.put(s2, integer);
        }
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcdw", "abcdww"));
    }
}
