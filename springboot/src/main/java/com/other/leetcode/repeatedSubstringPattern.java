package com.other.leetcode;

public class repeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[0] == chars[i]) {
                if (getaBoolean(s, i)) return true;
            }
        }
        return false;
    }

    private static Boolean getaBoolean(String s, int count) {
        if (s.length() % count == 0) {
            int i = s.length() / count;
            int index = 0;
            StringBuffer sb = new StringBuffer("");
            while (index < i) {
                index++;
                sb.append(s.substring(0, count));
            }
            return sb.toString().equals(s);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("aaaaaaaaaaaaaaaaaaaaaa"));
    }
}
