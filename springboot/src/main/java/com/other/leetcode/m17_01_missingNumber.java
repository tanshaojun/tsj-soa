package com.other.leetcode;

/**
 * 面试题 17.04. 消失的数字
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/30 17:51
 */
public class m17_01_missingNumber {

    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res ^ nums.length;
    }

    public int missingNumber1(int[] nums) {
        int res = -1;
        int[] tmp = new int[nums.length + 1];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i]] = 0;
        }
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == -1) {
                return i;
            }
        }
        return res;
    }
}
