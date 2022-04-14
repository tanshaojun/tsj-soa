package com.other.leetcode;

/**
 * 1512. 好数对的数目
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/7/20 10:17
 */
public class _1512_numIdenticalPairs {

    public int numIdenticalPairs(int[] nums) {
        if (null == nums) return 0;
        int res = 0;
        int[] t = new int[101];
        for (int i = 0; i < nums.length; i++) {
            res += t[nums[i]];
            t[nums[i]]++;
        }
        return res;
    }

}
