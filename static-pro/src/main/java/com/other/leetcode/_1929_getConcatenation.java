package com.other.leetcode;

/**
 * 1929. 数组串联
 *
 * @Author tansj
 * @Date 2022/4/12 10:53 上午
 * @Version 1.0
 */
public class _1929_getConcatenation {

    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] res = new int[len * 2];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            res[i + len] = nums[i];
        }
        return res;
    }

}
