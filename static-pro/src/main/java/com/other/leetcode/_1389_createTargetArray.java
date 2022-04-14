package com.other.leetcode;

import java.util.Arrays;

/**
 * 1389. 按既定顺序创建目标数组
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/23 15:54
 */
public class _1389_createTargetArray {


    public int[] createTargetArray(int[] nums, int[] index) {
        int[] ints = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < ints.length; i++) {
            ints[i] = -1;
        }
        for (int i = 0; i < index.length; i++) {
            int idx = index[i];
            while (ints[idx] != -1) {
                int tmp = ints[idx];
                ints[idx] = nums[i];
                nums[i] = tmp;
                idx++;
            }
            ints[idx] = nums[i];
        }
        return ints;
    }
}
