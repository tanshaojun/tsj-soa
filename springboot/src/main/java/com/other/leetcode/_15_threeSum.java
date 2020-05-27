package com.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/27 15:53
 */
public class _15_threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1;
                int right = len - 1;
                int sum = -nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > sum) {
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    }
                }
            }
        }
        return res;
    }

}
