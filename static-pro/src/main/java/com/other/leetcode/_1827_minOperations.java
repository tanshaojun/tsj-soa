package com.other.leetcode;

/**
 * 1827. 最少操作使数组递增
 *
 * @Author tansj
 * @Date 2021-05-12 15:50
 * @Version 1.0
 */
public class _1827_minOperations {

    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                res += (nums[i - 1] - nums[i] + 1);
                nums[i] = nums[i - 1] + 1;
            }
        }
        return res;
    }

}
