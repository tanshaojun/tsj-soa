package com.other.leetcode;

/**
 * 647. 回文子串
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/13 15:26
 */
public class _647_countSubstrings {

    /**
     * 中心扩展法
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int len = s.length();
        int res = 0;
//        for (int i = 0; i < len; i++) {
//            //奇
//            int left = i;
//            int right = i;
//            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
//                res++;
//                left--;
//                right++;
//            }
//            //偶
//            left = i;
//            right = i + 1;
//            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
//                res++;
//                left--;
//                right++;
//            }
//        }
        for (int i = 0; i < 2 * len; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }
        }
        return res;

    }

    public int countSubstrings1(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = i;
            res++;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                dp[0] = j + i;
                String sub = s.substring(j, dp[0] + 1);
                int start = 0;
                int end = sub.length() - 1;
                boolean flags = true;
                while (flags && start < end) {
                    if (sub.charAt(start) != sub.charAt(end))
                        flags = false;
                    start++;
                    end--;
                }
                if (flags) res++;
            }
        }
        return res;
    }


}
