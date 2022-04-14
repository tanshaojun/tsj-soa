package com.other.leetcode;

import java.util.Arrays;

/**
 * 673. 最长递增子序列的个数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/21 14:04
 */
public class _673_findNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        if (null == nums || 0 == nums.length) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        int[] counts = new int[len];
        Arrays.fill(counts, 1);
        int res = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                        counts[i] = counts[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        for (int i = 0; i < len; i++)
            if (max == dp[i]) res += counts[i];
        return res;
    }

}
