package com.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/27 16:34
 */
public class _18_fourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (null == nums || 4 > nums.length) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        //如果最大值的4倍都小于目标值，直接返回
        if (4 * nums[len - 1] < target) {
            return new ArrayList<>();
        }
        for (int i = 0; i < len - 3; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //如果连续的四个值相加都大于目标值，直接返回
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //如果最大值的3倍加上当前值都小于目标值，需要增加当前值
            if (nums[i] + 3 * nums[len - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                int sum = nums[i];
                //如果连续的3个值相加都大于目标值，直接返回
                if (sum + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                //去重
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                sum += nums[j];
                //如果最大值的2倍加上当前值都小于目标值，需要增加当前值
                if (sum + 2 * nums[len - 1] < target) {
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    if (sum == target - nums[left] - nums[right]) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum > target - nums[left] - nums[right]) {
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
