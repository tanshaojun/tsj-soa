package com.other.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class uncommonFromSentences {
    public static String[] uncommonFromSentences(String A, String B) {
        A = A + " " + B;
        String[] a = A.split(" ");
        Map<String, Integer> map = new HashMap<>(16);
        for (int i = 0; i < a.length; i++) {
            String s = a[i];
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                Integer integer = map.get(s);
                integer++;
                map.put(s, integer);
            }
        }
        List<String> list = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            Integer value = next.getValue();
            if (value == 1) {
                list.add(next.getKey());
            }
        }
        String[] ss = new String[list.size()];
        return list.toArray(ss);
    }

    public static void main(String[] args) {
        String[] strings = uncommonFromSentences("", "");
        System.out.println(strings);
    }
}
