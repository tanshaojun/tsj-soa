package com.other.leetcode;

/**
 * 面试题 08.01. 三步问题
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/9 15:34
 */
public class m08_01_waysToStep {

    /**
     * n = (n-1) +(n -2) + (n-3)
     *
     * @param n
     * @return
     */
    public  int waysToStep(int n) {
        if (1 == n) return 1;
        if (2 == n) return 2;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = dp[0] + dp[1] + 1;
        int m = 1000000007;
        for (int i = 3; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % m + dp[i - 3];
            dp[i] %= m;
        }
        return dp[n - 1];
    }

}
