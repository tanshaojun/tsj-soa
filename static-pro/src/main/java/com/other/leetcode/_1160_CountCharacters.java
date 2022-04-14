package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. 拼写单词
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/9/20 11:53
 */
public class _1160_CountCharacters {
    public static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>(16);
        char[] c = chars.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                map.put(c[i], map.get(c[i]) + 1);
            } else {
                map.put(c[i], 1);
            }
        }
        int len = 0;
        a:
        for (int i = 0; i < words.length; i++) {
            Map<Character, Integer> map1 = new HashMap<>(16);
            char[] chars1 = words[i].toCharArray();
            for (int j = 0; j < chars1.length; j++) {
                if (map.containsKey(chars1[j])) {
                    if (map1.containsKey(chars1[j])) {
                        map1.put(chars1[j], map1.get(chars1[j]) + 1);
                        if (map1.get(chars1[j]) > map.get(chars1[j])) {
                            continue a;
                        }
                    } else {
                        map1.put(chars1[j], 1);
                    }
                } else {
                    continue a;
                }
            }
            len += chars1.length;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }
}
