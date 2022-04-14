package com.other.offer;

import java.util.Arrays;

public class M50 {


    /**
     * 第一次只出现一次的字符
     *
     * @param str
     * @return
     */
    public char firstNotRepeating(String str) {
        if (null == str || 0 == str.length()) return ' ';
        int[] p = new int[26];
        Arrays.fill(p, -1);
        for (int i = 0; i < str.length(); i++) {
            int s = str.charAt(i) - 'a';
            if (p[s] == -1) {
                p[s] = i;
            } else {
                p[s] = -2;
            }
        }
        char res = ' ';
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < p.length; i++) {
            if (p[i] >= 0 && p[i] < min) {
                res = (char) ('a' + i);
                min = p[i];
            }
        }
        return res;
    }


}
