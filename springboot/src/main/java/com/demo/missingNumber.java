package com.demo;

public class missingNumber {
    public static   int missingNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            a += i;
            b += nums[i];
        }
        return a + nums.length - b;
    }

    public static   void main(String[] args) {
        int a = 8;
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
