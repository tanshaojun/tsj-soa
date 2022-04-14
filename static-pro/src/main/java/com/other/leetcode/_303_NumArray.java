package com.other.leetcode;

/**
 * 303. 区域和检索 - 数组不可变
 */
public class _303_NumArray {

    private int[] nums;

    public _303_NumArray(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        this.nums = new int[nums.length];
        this.nums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            this.nums[i] = this.nums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? nums[j] : nums[j] - nums[i - 1];
    }
}
