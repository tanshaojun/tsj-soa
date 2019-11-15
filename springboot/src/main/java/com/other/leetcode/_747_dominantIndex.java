package com.other.leetcode;

/**
 * 747. 至少是其他数字两倍的最大数
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/14 15:12
 */
public class _747_dominantIndex {
    public int dominantIndex(int[] nums) {
        int index = 0;
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max2 = max;
                    max = nums[i];
                    index = i;
                } else max2 = nums[i] > max2 ? nums[i] : max2;
            }
            if (max2 * 2 > max) return -1;
        }
        return index;
    }
}
