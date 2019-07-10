package com.other.leetcode;

/**
 * 28. 实现strStr()
 */
public class _28_StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("aabaaabaaac", "aabaaac"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        if ("".equals(needle)) return 0;
        int index = 0;
        int a = -1;
        int t = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (index > needle.length() - 1) return a;
            char c = haystack.charAt(i);
            char c1 = needle.charAt(index);
            if (c == needle.charAt(0) && index != 0 && t == -1) t = i;
            if (c == c1) {
                index++;
                if (a == -1) a = i;
            } else {
                if (t != -1) i = t - 1;
                t = -1;
                index = 0;
                a = -1;
            }
        }
        if (index != needle.length()) return -1;
        return a;
    }
}
