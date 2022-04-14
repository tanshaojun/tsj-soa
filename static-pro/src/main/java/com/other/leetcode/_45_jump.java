package com.other.leetcode;

/**
 * 45. 跳跃游戏 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/27 15:33
 */
public class _45_jump {

    public int jump(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int res = 0;
        int right = nums[0];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur < i) {
                res++;
                cur = right;
            }
            right = Math.max(right, i + nums[i]);
        }
        return res;
    }

}
