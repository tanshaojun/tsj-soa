package com.other.leetcode;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/14 14:19
 */
public class _611_triangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] <= nums[k]) break;
                    res++;
                }
            }
        }
        return res;
    }
}
