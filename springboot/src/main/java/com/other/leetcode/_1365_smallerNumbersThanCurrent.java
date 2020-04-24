package com.other.leetcode;

/**
 * 1365. 有多少小于当前数字的数字
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/23 15:36
 */
public class _1365_smallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] > nums[j]) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

}
