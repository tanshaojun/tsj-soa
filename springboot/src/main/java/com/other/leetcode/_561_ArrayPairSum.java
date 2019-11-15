package com.other.leetcode;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/14 14:50
 */
public class _561_ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++)
            if (i % 2 == 0) sum += nums[i];
        return sum;
    }
}
