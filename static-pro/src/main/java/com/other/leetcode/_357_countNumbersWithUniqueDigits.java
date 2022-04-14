package com.other.leetcode;

/**
 * 357. 统计各位数字都不同的数字个数
 *
 * @Author tansj
 * @Date 2022/4/11 2:45 下午
 * @Version 1.0
 */
public class _357_countNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (0 == n) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (10 - (i - 1));
        }
        return dp[n];
    }

}
