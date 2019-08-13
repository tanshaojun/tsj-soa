package com.other.leetcode;

public class _665_CheckPossibility {
    public static boolean checkPossibility(int[] nums) {
        int size = 0;
        int index = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                size++;
                index = i;
            }
            if (size == 2) return false;
        }
        if (index == -1) return true;
        boolean b = true;
        int tmp = nums[index - 1];
        nums[index - 1] = nums[index];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                b = false;
                break;
            }
        }
        if (b) return b;
        nums[index - 1] = tmp;
        nums[index] = tmp;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
    }
}
