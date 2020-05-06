package com.other.leetcode;

/**
 * 42. 接雨水
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/6 18:26
 */
public class _42_trap {

    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        while (left < right) {
            if (leftMax < rightMax) {
                res += leftMax - height[left++];
                leftMax = Math.max(height[left], leftMax);
            } else {
                res += rightMax - height[right--];
                rightMax = Math.max(height[right], rightMax);
            }
        }
        return res;
    }

}
