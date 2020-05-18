package com.other.leetcode;

/**
 * 152. 乘积最大子数组
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/18 10:20
 */
public class _152_maxProduct {

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        // dp_max[i] 指的是以第 i 个数结尾的 乘积最大 的连续子序列
        int[] dp_max = new int[nums.length + 1];
        dp_max[0] = 1;
        // dp_min[i] 指的是以第 i 个数结尾的 乘积最小 的连续子序列
        int[] dp_min = new int[nums.length + 1];
        dp_min[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            //如果目标值是负数，会导致最大变最小，这里需要交换一下
            if (nums[i - 1] < 0) {
                int t = dp_max[i - 1];
                dp_max[i - 1] = dp_min[i - 1];
                dp_min[i - 1] = t;
            }
            dp_max[i] = Math.max(nums[i - 1], dp_max[i - 1] * nums[i - 1]);
            dp_min[i] = Math.min(nums[i - 1], dp_min[i - 1] * nums[i - 1]);
            res = Math.max(res, dp_max[i]);
        }
        return res;
    }

}
