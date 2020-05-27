package com.other.leetcode;

import java.util.HashMap;

/**
 * 1027. 最长等差数列
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/26 16:25
 */
public class _1027_longestArithSeqLength {

    public int longestArithSeqLength(int[] A) {
        if (A == null || 0 == A.length) return -1;
        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashMap<>(16);
        }
        int res = 1;
        /**
         * 以i为结尾计算等差数列的最大值
         */
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                if (dp[j].containsKey(diff)) {
                    dp[i].put(diff, dp[j].get(diff) + 1);
                } else {
                    dp[i].put(diff, 2);
                }
                res = Math.max(res, dp[i].get(diff));
            }
        }
        return res;
    }

}
