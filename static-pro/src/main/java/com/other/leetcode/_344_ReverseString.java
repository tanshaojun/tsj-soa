package com.other.leetcode;

/**
 * 344. 反转字符串
 */
public class _344_ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("1"));
    }

    public static String reverseString(String s) {
        StringBuffer sb = new StringBuffer("");
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(String.valueOf(s.charAt(i)));
        }
        return sb.toString();
    }
}
