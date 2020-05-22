package com.other.leetcode;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/21 10:57
 */
public class _300_lengthOfLIS {


    /**
     * 二分
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len + 1];
        int res = 1;
        dp[res] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > dp[res]) {
                dp[++res] = nums[i];
            } else {
                int left = 1;
                int right = res;
                int p = 0;
                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if (dp[mid] >= nums[i]) {
                        right = mid - 1;
                        p = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                dp[p] = nums[i];
            }
        }
        return res;
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int res = 1;
        //每次计算以num[i]为结尾的递增子序列
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
