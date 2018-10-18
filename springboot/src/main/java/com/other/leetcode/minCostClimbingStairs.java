package com.other.leetcode;

public class minCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100}));

    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            int current = i == cost.length ? 0 : cost[i];
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + current;
        }
        return dp[cost.length];
    }

}
