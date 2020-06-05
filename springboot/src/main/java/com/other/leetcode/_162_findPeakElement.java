package com.other.leetcode;

/**
 * 162. 寻找峰值
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/5 15:10
 */
public class _162_findPeakElement {

    public int findPeakElement(int[] nums) {
        if (null == nums || 0 == nums.length) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
