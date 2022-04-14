package com.other.leetcode;

/**
 * 面试题42. 连续子数组的最大和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/9 14:32
 */
public class m42_maxSubArray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

}
