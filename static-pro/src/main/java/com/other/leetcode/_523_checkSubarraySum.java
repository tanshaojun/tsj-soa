package com.other.leetcode;

/**
 * 523. 连续的子数组和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/13 13:42
 */
public class _523_checkSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (null == nums) return false;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        for (int size = 1; size < nums.length; size++) {
            for (int i = 0; i < nums.length - size; i++) {
                dp[i] += nums[i + size];
                if (k == dp[i] || (k != 0 && (dp[i] % k) == 0)) return true;
            }
        }
        return false;
    }
}
