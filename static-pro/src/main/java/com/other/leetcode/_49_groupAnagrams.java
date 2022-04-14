package com.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/27 14:27
 */
public class _49_groupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>(16);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(str);
                map.put(s, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }

}
