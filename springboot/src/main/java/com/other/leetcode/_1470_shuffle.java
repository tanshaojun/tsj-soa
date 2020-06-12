package com.other.leetcode;

/**
 * 1470. 重新排列数组
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/11 17:37
 */
public class _1470_shuffle {

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int index = 0;
        for (int i = 0; i < n; i++) {
            ans[index++] = nums[i];
            ans[index++] = nums[n + i];
        }
        return ans;
    }
}
