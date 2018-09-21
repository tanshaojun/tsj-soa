package com.demo;

public class checkPossibility {
    public static boolean checkPossibility(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                int num = nums[i];
                int num1 = nums[i + 1];
                tmp[i] = num1 - num;
            } else {
                tmp[i] = nums[i];
            }
        }
        System.out.println(tmp);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
    }
}
