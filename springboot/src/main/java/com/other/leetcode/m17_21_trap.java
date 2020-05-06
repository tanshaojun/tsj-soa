package com.other.leetcode;

/**
 * 面试题 17.21. 直方图的水量
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/6 15:26
 */
public class m17_21_trap {

    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int left = 0, right = height.length - 1;
        int leftmax = height[left], rightmax = height[right];
        int res = 0;

        while (left < right) {
            if (leftmax < rightmax) {
                res += leftmax - height[left++];
                leftmax = Math.max(height[left], leftmax);
            } else {
                res += rightmax - height[right--];
                rightmax = Math.max(height[right], rightmax);
            }
        }
        return res;
    }

}
