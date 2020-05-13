package com.other.leetcode;

/**
 * 983. 最低票价
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/13 10:44
 */
public class _983_mincostTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int[] bj = new int[days[len - 1] + 1];
        for (int i = 0; i < len; i++) bj[days[i]] = 1;
        int[] dp = new int[bj.length];
        for (int i = 1; i < bj.length; i++) {
            if (bj[i] == 1) {
                dp[i] = Math.min(dp[i - 1] + costs[0],
                        Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(i - 30, 0)] + costs[2]));
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

}

