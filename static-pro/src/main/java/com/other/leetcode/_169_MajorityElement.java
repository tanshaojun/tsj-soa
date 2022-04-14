package com.other.leetcode;


import java.util.Arrays;

/**
 * 169. 求众数
 */
public class _169_MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
