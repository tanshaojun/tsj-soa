package com.other.leetcode;

/**
 * 540. 有序数组中的单一元素
 */
public class _540_SingleNonDuplicate {
    public static   int singleNonDuplicate(int[] nums) {
        if (nums.length <= 1) return nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            count = count ^ nums[i];
        return count;
    }

    public static   void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 2, 1,1,2}));
    }
}
