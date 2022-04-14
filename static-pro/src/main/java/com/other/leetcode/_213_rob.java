package com.other.leetcode;

/**
 * 213. 打家劫舍 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/22 14:36
 */
public class _213_rob {

    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        int len = nums.length;
        int[] dp = new int[len];
        //抢第一个，不抢最后一个
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        //不抢第一个，抢最后一个
        int[] dp1 = new int[len];
        dp1[0] = 0;
        dp1[1] = Math.max(dp1[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        return Math.max(dp[len - 2], dp1[len - 1]);
    }

}
