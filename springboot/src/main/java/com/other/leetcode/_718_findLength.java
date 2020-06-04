package com.other.leetcode;

/**
 * 718. 最长重复子数组
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/3 19:24
 */
public class _718_findLength {

    public int findLength(int[] A, int[] B) {
        if (null == A || null == B || 0 == A.length || 0 == B.length) return 0;
        int max = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

}
