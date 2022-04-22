package com.other.leetcode;

/**
 * 2161. 根据给定数字划分数组
 *
 * @Author tansj
 * @Date 2022/4/15 15:30
 * @Version 1.0
 */
public class _2161_pivotArray {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int index = 0;
        int count = 0;
        for (int num : nums) {
            if (num == pivot) {
                count++;
            } else if (num < pivot) {
                res[index++] = num;
            }
        }
        for (int i = 0; i < count; i++) {
            res[index++] = pivot;
        }
        for (int num : nums) {
            if (num > pivot) {
                res[index++] = num;
            }
        }
        return res;
    }
}
