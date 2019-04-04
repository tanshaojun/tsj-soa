package com.other.leetcode;

public class validPalindrome {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int a = 0;
        int b = chars.length - 1;
        int t = 1;
        while (a <= b) {
            char aChar = chars[a];
            char aChar1 = chars[b];
            if (aChar == aChar1) {
                a++;
                b--;
            } else {
                return validPalindrome(chars, a, b - 1) || validPalindrome(chars, a + 1, b);
            }
        }
        return true;
    }

    private boolean validPalindrome(char[] chars, int l, int r) {
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
