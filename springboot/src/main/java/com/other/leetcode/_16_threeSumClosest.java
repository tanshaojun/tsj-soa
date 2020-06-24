package com.other.leetcode;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/24 11:41
 */
public class _16_threeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int a = nums[i] + nums[left] + nums[right];
                int b = Math.abs(a - target);
                int c = Math.abs(res - target);
                if (b < c) res = a;
                if (a > target) {
                    right--;
                } else if (a < target) {
                    left++;
                } else {
                    return a;
                }
            }
        }
        return res;
    }

}
