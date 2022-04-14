package com.other.leetcode;

/**
 * 面试题53 - II. 0～n-1中缺失的数字
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/25 17:06
 */
public class m53_2_missingNumber {
    /**
     * 异或
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int num : nums) res ^= num;
        for (int i = 0; i <= len; i++) res ^= i;
        return res;
    }


    /**
     * 二分
     *
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mid == nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
