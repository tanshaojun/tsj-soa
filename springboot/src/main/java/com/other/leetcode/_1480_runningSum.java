package com.other.leetcode;

/**
 * 1480. 一维数组的动态和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/15 15:38
 */
public class _1480_runningSum {
    public int[] runningSum(int[] nums) {
        if (null == nums || 0 == nums.length) return nums;
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }
}
