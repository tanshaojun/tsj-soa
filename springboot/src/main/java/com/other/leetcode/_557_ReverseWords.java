package com.other.leetcode;

/**
 * 557. 反转字符串中的单词 III
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/14 14:49
 */
public class _557_ReverseWords {
    public String reverseWords(String s) {
        if ("".equals(s)) return s;
        StringBuffer sb = new StringBuffer("");
        String[] split = s.trim().split(" ");
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            for (int j = s1.length() - 1; j >= 0; j--) {
                sb.append(s1.charAt(j));
                if (i != split.length - 1 && j == 0) sb.append(" ");
            }
        }
        return sb.toString();
    }
}
