package com.other.leetcode;

public class isPalindromeByString {
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

    public static void main(String[] args) {
        String r = "[^a-zA-Z0-9]";
        String s = "0123456789.";
        String s1 = s.replaceAll(r, "");
        System.out.println(s1);

    }
}
