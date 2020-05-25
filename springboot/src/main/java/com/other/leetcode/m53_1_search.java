package com.other.leetcode;

/**
 * 面试题53 - I. 在排序数组中查找数字 I
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/25 16:50
 */
public class m53_1_search {

    public int search(int[] nums, int target) {
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                for (int i = mid - 1; i >= left; i--) {
                    if (nums[i] != target) break;
                    count++;
                }
                for (int i = mid + 1; i <= right; i++) {
                    if (nums[i] != target) break;
                    count++;
                }
                return count + 1;
            }
        }
        return count;
    }

}
