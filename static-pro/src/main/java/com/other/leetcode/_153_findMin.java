package com.other.leetcode;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/14 13:52
 */
public class _153_findMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] >= nums[left]) return nums[left];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid + 1] < nums[mid]) return nums[mid + 1];
            if (nums[mid - 1] > nums[mid]) return nums[mid];
            if (nums[mid] > nums[0]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
