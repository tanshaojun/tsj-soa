package com.other.leetcode;

/**
 * 844. 比较含退格的字符串
 */
public class _844_backspaceCompare {
    public static boolean backspaceCompare(String S, String T) {
        return get(S.toCharArray()).equals(get(T.toCharArray()));
    }

    private static String get(char[] s) {
        StringBuffer sb = new StringBuffer("");
        int a = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == '#') {
                a++;
            } else {
                if (a == 0) {
                    sb.append(s[i]);
                } else {
                    a--;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("a##c", "#a#c"));
    }
}
