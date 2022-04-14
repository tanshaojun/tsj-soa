package com.other.leetcode;

/**
 * 189. 旋转数组
 */
public class _189_Rotate {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if (k == 0 || k % len == 0)
            return;
        int[] array = nums.clone();
        for (int i = 0; i < len; i++) {
            int index = (i + k) % len;
            nums[index] = array[i];
        }
//        while (k > 0) {
//            for (int i = nums.length - 1; i > 0; i--) {
//                int tmp = nums[i];
//                nums[i] = nums[i - 1];
//                nums[i - 1] = tmp;
//            }
//            k--;
//        }
    }

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
    }
}
