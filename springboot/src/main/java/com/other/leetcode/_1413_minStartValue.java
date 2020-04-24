package com.other.leetcode;

/**
 * 1413. 逐步求和得到正数的最小值
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/24 11:15
 */
public class _1413_minStartValue {

    public int minStartValue(int[] nums) {
        int res = 1;
        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 1) {
                res += (1 - sum);
                sum = 1;
            }
        }
        return res;
    }

}
