package com.other.leetcode;

/**
 * 96. 不同的二叉搜索树
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/11 11:00
 */
public class _96_numTrees {

    public int numTrees(int n) {
        if (0 == n) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
