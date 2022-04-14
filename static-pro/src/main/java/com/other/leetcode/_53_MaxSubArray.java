package com.other.leetcode;

/**
 * 53. 最大子序和
 */
public class _53_MaxSubArray {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
            }
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }

    public int maxSubArray1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 1; i <= nums.length; i++) {
            max = Math.max(nums[i - 1], max + nums[i - 1]);
            result = Math.max(result, max);
        }
        return result;
    }

}
