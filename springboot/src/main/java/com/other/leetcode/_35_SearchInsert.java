package com.other.leetcode;

/**
 * 35. 搜索插入位置
 */
public class _35_SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target)
                    return i;
            }
        } else
            return 0;
        return nums.length;
    }
}
