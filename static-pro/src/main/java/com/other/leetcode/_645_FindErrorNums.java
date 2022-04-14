package com.other.leetcode;

import java.util.Arrays;

/**
 * 645. 错误的集合
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/311:33
 */
public class _645_FindErrorNums {
    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int a = -1;
        int sum = nums[0];
        int sum1 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) a = nums[i - 1];
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) sum1 += (i + 1);
        return new int[]{a, sum1 - sum + a};
    }

    public static void main(String[] args) {
        int[] errorNums = findErrorNums(new int[]{1, 1});
        System.out.println();
    }
}
