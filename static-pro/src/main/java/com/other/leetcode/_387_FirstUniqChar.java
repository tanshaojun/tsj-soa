package com.other.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 */
public class _387_FirstUniqChar {
    public static int firstUniqChar(String s) {
        int c = -1;
        Map<String, List<Integer>> map = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i));
            if (map.get(s1) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(i);
                map.put(s1, list);
            } else {
                List<Integer> list = map.get(s1);
                Integer integer = list.get(0);
                integer++;
                List<Integer> list1 = new ArrayList<>();
                list1.add(integer);
                list1.add(i);
                map.put(s1, list1);
            }
        }
        Iterator<Map.Entry<String, List<Integer>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Integer>> next = iterator.next();
            List<Integer> value = next.getValue();
            Integer integer = value.get(0);
            Integer integer1 = value.get(1);
            if (integer == 0) {
                if (c != -1) {
                    if (integer1 < c) c = integer1;
                } else c = integer1;
            }
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("cc"));
    }
}
