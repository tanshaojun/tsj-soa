package com.other.leetcode;

public class integerBreak {
    /**
     * 常规解法
     *
     * @param n
     * @return
     */
    public static int integerBreak1(int n) {
        if (n == 2 || n == 3)
            return n - 1;
        if (n == 4)
            return n;
        int sum = 1;
        while (n > 4) {
            sum *= 3;
            n = n - 3;
        }
        return sum * n;
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * Math.max(dp[i - j], (i - j)));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(13));
    }
}
