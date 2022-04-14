package com.other.leetcode;

/**
 * 409. 最长回文串
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/14 11:31
 */
public class _409_longestPalindrome {

    public int longestPalindrome(String s) {
        int[] t = new int[52];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (c >= 65 && c <= 90) t[c - 65] += 1;
            if (c >= 97 && c <= 122) t[c - 71] += 1;
        }
        int res = 0;
        for (int i = 0; i < t.length; i++) {
            if ((t[i] & 1) == 1) res++;
        }
        return res == s.length() ? 1 : s.length() - res + 1;
    }

}
