package com.other.leetcode;

/**
 * 27. 移除元素
 */
public class _27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = -1;
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                tmp = nums[i];
                nums[i] = nums[++index];
                nums[index] = tmp;
            }

        }
        return index + 1;
    }
}
