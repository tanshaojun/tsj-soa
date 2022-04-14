package com.other.leetcode;

/**
 * 69. x 的平方根
 */
public class _69_MySqrt {

    public int mySqrt(int x) {
        int ans = -1;
        if (0 == x) return 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else right = mid - 1;
        }
        return ans;
    }

}
