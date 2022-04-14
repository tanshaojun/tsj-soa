package com.other.leetcode;

/**
 * 125. 验证回文串
 */
public class _125_IsPalindrome {

    public boolean isPalindrome(String s) {
        if ("".equals(s)) {
            return true;
        }
        String re = "[^a-zA-Z0-9]";
        s = s.replaceAll(re, "").toLowerCase();
        if ("".equals(s)) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
