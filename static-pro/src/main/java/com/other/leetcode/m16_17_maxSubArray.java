package com.other.leetcode;

/**
 * 面试题 16.17. 连续数列
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/6 17:24
 */
public class m16_17_maxSubArray {

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            count = Math.max(count + num, num);
            max = Math.max(max, count);
        }
        return max;
    }

}
