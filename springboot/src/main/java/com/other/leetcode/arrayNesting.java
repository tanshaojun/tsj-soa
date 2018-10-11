package com.other.leetcode;

public class arrayNesting {
    public static   int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = 1;
            int count = i;
            count = nums[count];
            while (nums[count] != nums[i]) {
                c++;
                count = nums[count];
            }
            max = max > c ? max : c;
            if (max >= nums.length - 1 - i) {
                return max;
            }
        }
        return max;
    }


    public static   void main(String[] args) {
        System.out.println(arrayNesting(new int[]{0, 2, 1}));
    }
}
