package com.other.leetcode;

import java.util.Arrays;

/**
 * 434. 字符串中的单词数
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/1115:18
 */
public class _434_countSegments {
    public static int countSegments(String s) {
        s.trim();
        if ("".equals(s) || null == s) return 0;
        String[] split = s.split(" ");
        long count = Arrays.stream(split).filter(ss -> !"".equals(ss)).count();
        return (int) count;
    }

    public static void main(String[] args) {
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }

}
