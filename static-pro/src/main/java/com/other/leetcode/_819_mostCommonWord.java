package com.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 819. 最常见的单词
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/1115:57
 */
public class _819_mostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        List<String> list = new ArrayList<>();
        for (String s : banned) {
            list.add(s.toLowerCase());
        }
        Map<String, Integer> map = new HashMap<>(16);
        String[] split = paragraph.toLowerCase().split("[!?',;. ]");
        for (String s : split) {
            if (!"".equals(s) && !list.contains(s)) {
                if (map.containsKey(s)) {
                    Integer count = map.get(s);
                    count++;
                    map.put(s, count);
                } else map.put(s, 1);
            }
        }
        String key = map.entrySet().stream().max((a, b) -> a.getValue() - b.getValue()).get().getKey();
        return key;
    }

    public static void main(String[] args) {
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new
                String[]{"a"}));

    }
}
