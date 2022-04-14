package com.other.leetcode;

/**
 * 724. 寻找数组的中心索引
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/14 15:10
 */
public class _724_pivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length > 1) {
            int sum = 0;
            int sum1 = 0;
            int index = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                while (index > i)
                    sum1 += nums[index--];
                if (sum == sum1 && index == i)
                    return i;
                sum += nums[i];
                sum1 = 0;
                index = nums.length - 1;
            }
        }
        return -1;
    }
}
