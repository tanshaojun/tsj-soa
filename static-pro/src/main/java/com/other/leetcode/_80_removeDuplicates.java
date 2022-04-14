package com.other.leetcode;

/**
 * 80. 删除排序数组中的重复项 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/6 17:16
 */
public class _80_removeDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0}));
    }

    public static int removeDuplicates(int[] nums) {
        if (null == nums || nums.length < 1) return 0;
        int len = 1;
        int a = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == a) {
                count++;
            } else {
                count = 1;
                a = nums[i];
            }
            if (count <= 2) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
}
