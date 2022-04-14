package com.other.leetcode;

/**
 * 713. 乘积小于K的子数组
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/24 14:38
 */
public class _713_numSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int now = 1, times = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            now *= nums[right];
            while (now >= k) now /= nums[left++];
            times += right - left + 1;
        }
        return times;
    }

}
