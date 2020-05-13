package com.other.leetcode;

/**
 * 5. 最长回文子串
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/13 16:16
 */
public class _5_longestPalindrome {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (0 == len) return s;
        int max = 0;
        String res = "";
        for (int i = 0; i < 2 * len; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > max) {
                    max = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return res;
    }

}
