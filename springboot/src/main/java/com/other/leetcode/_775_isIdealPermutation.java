package com.other.leetcode;

/**
 * 775. 全局倒置与局部倒置
 *
 * @Author tansj
 * @Date 2021-05-14 15:53
 * @Version 1.0
 */
public class _775_isIdealPermutation {

    public boolean isIdealPermutation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) > 1)
                return false;
        }
        return true;
    }

    /**
     * 超时
     *
     * @param nums
     * @return
     */
    public boolean isIdealPermutation1(int[] nums) {
        int len = nums.length;
        int a = 0;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                a++;
            }
        }

        int b = 0;
        for (int i = 0; i < len; i++) {
            int q = len - i - 1;
            int w = ((1 + q) * q) / 2;
            if (w + b < a) {
                return false;
            }
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    b++;
                    if (b > a) {
                        return false;
                    }
                }

            }
        }
        return a == b;
    }

}
