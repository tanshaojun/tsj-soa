package com.other.leetcode;

/**
 * 1437. 是否所有 1 都至少相隔 k 个元素
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/6 16:55
 */
public class _1437_kLengthApart {

    public boolean kLengthApart(int[] nums, int k) {
        int index = -100000;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i - index - 1 < k) return false;
                index = i;
            }
        }
        return true;
    }
}
