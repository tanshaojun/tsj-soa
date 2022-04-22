package com.other.leetcode;

/**
 * 2006. 差的绝对值为 K 的数对数目
 *
 * @Author tansj
 * @Date 2022/4/21 14:55
 * @Version 1.0
 */
public class _2006_countKDifference {

    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    res++;
                }
            }
        }
        return res;
    }

}
