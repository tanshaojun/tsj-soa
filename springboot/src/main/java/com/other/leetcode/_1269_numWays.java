package com.other.leetcode;

/**
 * 1269. 停在原地的方案数
 *
 * @Author tansj
 * @Date 2021-05-13 09:42
 * @Version 1.0
 */
public class _1269_numWays {

    public int numWays(int steps, int arrLen) {
        int m = 1000000007;
        int min = Math.min(steps, arrLen - 1);
        int[] dp = new int[min + 1];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            int[] next = new int[min + 1];
            for (int j = 0; j <= min; j++) {
                next[j] = dp[j];
                if (j - 1 >= 0) {
                    next[j] = (next[j] + dp[j - 1]) % m;
                }
                if (j + 1 <= min) {
                    next[j] = (next[j] + dp[j + 1]) % m;
                }
            }
            dp = next;
        }
        return dp[0];
    }

    public int numWays1(int steps, int arrLen) {
        int m = 1000000007;
        int min = Math.min(steps, arrLen - 1);
        int[][] dp = new int[steps + 1][min + 1];
        dp[0][0] = 1;
        //dp[i][j]表示在走i步的情况下回到j点的次数，所以下一步只与上一步有关，
        // 计算在走i步的情况下回到j点的次数的时候，有如下三种情况：
        //1.如果i-1在j点，则可以不动就回到i,j点，所以dp[i-1][j]
        //2.如果i-1在j-1点，则可以向右一步就回到i,j点，所以dp[i-1][j-1]
        //3.如果i-1在j+1点，则可以向左一步就回到i,j点，所以dp[i-1][j+1]
        // 则dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + dp[i-1][j+1]
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= min; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % m;
                }
                if (j + 1 <= min) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % m;
                }
            }
        }
        return dp[steps][0];
    }

}
