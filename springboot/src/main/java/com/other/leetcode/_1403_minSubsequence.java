package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/18 11:22
 */
public class _1403_minSubsequence {


    public List<Integer> minSubsequence(int[] nums) {
        if (null == nums) return new ArrayList<>();
        quickSort(nums, 0, nums.length - 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        List<Integer> res = new ArrayList<>();
        int s = 0;
        for (int num : nums) {
            s += num;
            if (s > sum - s) {
                res.add(num);
                break;
            }
            res.add(num);
        }
        return res;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            swap(nums, mid, right);
            int[] arr = partition(nums, left, right);
            quickSort(nums, left, arr[0] - 1);
            quickSort(nums, arr[1] + 1, right);
        }
    }

    private int[] partition(int[] nums, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (nums[left] > nums[right]) {
                swap(nums, left++, ++less);
            } else if (nums[left] < nums[right]) {
                swap(nums, left, --more);
            } else {
                left++;
            }
        }
        swap(nums, right, more);
        return new int[]{less + 1, more};
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }


}
