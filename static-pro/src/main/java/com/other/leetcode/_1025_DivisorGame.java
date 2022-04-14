package com.other.leetcode;

/**
 * 1025. 除数博弈
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/23 9:46
 */
public class _1025_DivisorGame {
    public static boolean divisorGame(int N) {
        if (N < 2) return false;
        int[] dp = new int[N];
        dp[1] = 1;
        for (int i = 3; i <= N; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (i % j == 0 && dp[i - j - 1] == 0) {
                    dp[i - 1] = 1;
                    break;
                }
            }
        }
        return dp[N - 1] == 1;
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(2));
    }
}
