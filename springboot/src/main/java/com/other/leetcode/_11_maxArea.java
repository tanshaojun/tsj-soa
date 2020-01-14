package com.other.leetcode;

/**
 * 11. 盛最多水的容器
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/9 13:40
 */
public class _11_maxArea {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            res = Math.max(res, (right - left) * min);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
