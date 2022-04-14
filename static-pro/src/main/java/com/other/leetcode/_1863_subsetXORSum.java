package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1863. 找出所有子集的异或总和再求和
 *
 * @Author tansj
 * @Date 2022/4/12 11:01 上午
 * @Version 1.0
 */
public class _1863_subsetXORSum {

    /**
     * 总和
     */
    int res = 0;
    /**
     * 子集和
     */
    int tmp = 0;

    public int subsetXORSum(int[] nums) {
        dfs(0, nums, tmp);
        return res;
    }

    private void dfs(int start, int[] nums, int tmp) {
        res += tmp;
        for (int i = start; i < nums.length; i++) {
            tmp ^= nums[i];
            dfs(i + 1, nums, tmp);
            tmp ^= nums[i];
        }
    }

}
