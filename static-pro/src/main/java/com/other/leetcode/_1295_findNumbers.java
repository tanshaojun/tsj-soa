package com.other.leetcode;

/**
 * 1295. 统计位数为偶数的数字
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/3 10:12
 */
public class _1295_findNumbers {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (String.valueOf(nums[i]).length() % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
