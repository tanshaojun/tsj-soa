package com.other.leetcode;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/9 16:33
 */
public class m17_16_massage {
    public int massage(int[] nums) {
        if (null == nums || 0 == nums.length) return 0;
        int a = nums[0];
        if (1 == nums.length) return a;
        int b = Math.max(a, nums[1]);
        int c;
        for (int i = 2; i < nums.length; i++) {
            c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}
