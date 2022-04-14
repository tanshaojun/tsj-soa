package com.other.leetcode;

/**
 * 55. 跳跃游戏
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/27 15:14
 */
public class _55_canJump {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0}));
    }

    public static boolean canJump(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return false;
        }
        int length = nums.length;
        int right = 0;
        for (int i = 0; i < length; i++) {
            if (right >= i) {
                right = Math.max(right, i + nums[i]);
            }
            if (right >= length - 1) {
                return true;
            }
        }
        return false;
    }

}
