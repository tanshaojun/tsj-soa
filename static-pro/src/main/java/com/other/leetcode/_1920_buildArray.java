package com.other.leetcode;

/**
 * 1920. 基于排列构建数组
 *
 * @Author tansj
 * @Date 2022/4/12 10:35 上午
 * @Version 1.0
 */
public class _1920_buildArray {

    public int[] buildArray1(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }

    public int[] buildArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] /= 1000;
        }
        return nums;
    }

}
