package com.other.leetcode;

/**
 * 26. 删除排序数组中的重复项
 */
public class _26_RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                nums[j++] = nums[i];
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{}));
    }
}
