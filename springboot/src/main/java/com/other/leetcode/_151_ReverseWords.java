package com.other.leetcode;

/**
 * 151. 翻转字符串里的单词
 */
public class _151_ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords1(String s) {
        if ("".equals(s)) return s;
        StringBuffer sb = new StringBuffer("");
        String[] split = s.trim().split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            if (!"".equals(split[i])) {
                sb.append(split[i]);
                if (i != 0) sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String reverseWords(String s) {
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
