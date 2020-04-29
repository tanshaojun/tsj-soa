package com.other.leetcode;

/**
 * 33. 搜索旋转排序数组
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/27 14:21
 */
public class _33_search {


    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) return -1;
        int res = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return res;
    }
}
