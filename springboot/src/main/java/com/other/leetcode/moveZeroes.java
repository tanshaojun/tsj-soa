package com.other.leetcode;

public class moveZeroes {
    public static void moveZeroes(int[] nums) {
        int a = -1;
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num != 0) {
                if (i > a && a != -1) {
                    nums[a] = num;
                    nums[i] = 0;
                    while (nums[a] != 0) a++;
                }
            } else {
                if (a == -1) a = i;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
