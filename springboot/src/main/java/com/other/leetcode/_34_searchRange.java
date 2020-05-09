package com.other.leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/8 15:40
 */
public class _34_searchRange {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int a = -1;
        int b = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                a = mid;
                b = mid;
                for (int i = mid - 1; i >= left; i--) {
                    if (nums[i] < target) break;
                    if (nums[i] == target) {
                        a = i;
                    }
                }
                for (int i = mid + 1; i <= right; i++) {
                    if (nums[i] > target) break;
                    if (nums[i] == target) {
                        b = i;
                    }
                }
                break;
            }
        }
        return new int[]{a, b};
    }
}
