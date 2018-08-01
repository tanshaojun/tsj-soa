package com.demo;

public class SubarraySum {
    public static   void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }

    public static   int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) count++;
            if (i == nums.length - 1 && index != nums.length - 1) {
                i = index++;
                sum = 0;
            }
        }
        return count;
    }
}
