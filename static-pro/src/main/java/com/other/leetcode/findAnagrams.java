package com.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/1419:19
 */
public class findAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (null == s || "".equals(s) || s.length() < p.length()) {
            return list;
        }
        int length = p.length();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        lable:
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String substring = s.substring(i, length + i);
            char[] chars1 = substring.toCharArray();
            Arrays.sort(chars1);
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != chars1[j]) continue lable;
            }
            list.add(i);

        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }


}
