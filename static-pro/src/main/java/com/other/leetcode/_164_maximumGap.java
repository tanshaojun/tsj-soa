package com.other.leetcode;

/**
 * 164. 最大间距
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/29 14:30
 */
public class _164_maximumGap {

    /**
     * 桶排序经典题
     *
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (min == max) return 0;
        int len = nums.length;
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        boolean[] flags = new boolean[len + 1];
        for (int i = 0; i < nums.length; i++) {
//            int index (nums[i] - min) * len / (max - min); 超出int长度
            int index = getIndex(nums[i], len, max, min);
            maxs[index] = flags[index] ? Math.max(maxs[index], nums[i]) : nums[i];
            mins[index] = flags[index] ? Math.min(mins[index], nums[i]) : nums[i];
            flags[index] = true;
        }
        int res = 0;
        max = maxs[0];
        for (int i = 1; i <= len; i++) {
            if (flags[i]) {
                res = Math.max(res, mins[i] - max);
                max = maxs[i];
            }
        }
        return res;
    }

    private int getIndex(long a, long b, long c, long d) {
        return (int) ((a - d) * b / (c - d));
    }

}
