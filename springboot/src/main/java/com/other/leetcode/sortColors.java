package com.other.leetcode;

public class sortColors {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,0};
        sortColors(ints);
    }

    public static void sortColors(int[] nums) {
        int index = 0;
        int index1 = nums.length - 1;
        for (int i = 1; i < nums.length; i++) {
            if (i > index1 || index >= index1) break;
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                index++;
            }
            if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[index1];
                nums[index1] = tmp;
                index1--;
            }
        }
    }
}
