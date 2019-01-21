package com.other.leetcode;

public class removeDuplicates {
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
