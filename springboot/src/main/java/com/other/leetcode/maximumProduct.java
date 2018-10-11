package com.other.leetcode;

import java.util.Arrays;

public class maximumProduct {
    public static   int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return nums[0] * nums[1] * nums[nums.length - 1] > nums[nums.length - 1] * nums[nums.length - 2] * nums[nums
                .length - 3] ? nums[0] * nums[1] * nums[nums.length - 1] : nums[nums.length - 1] * nums[nums.length -
                2] * nums[nums.length - 3];
    }

    public static   void main(String[] args) {
        System.out.println(maximumProduct(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
