package com.other.leetcode;

public class isPalindrome {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x != 0 && x % 10 == 0) {
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l <= r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));

    }
}
