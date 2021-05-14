package com.other.leetcode;

/**
 * 1482. 制作 m 束花所需的最少天数
 *
 * @Author tansj
 * @Date 2021-05-12 17:25
 * @Version 1.0
 */
public class _1482_minDays {

    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if (m * k > len) {
            return -1;
        }
        int right = -1;
        int left = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            right = Math.max(right, bloomDay[i]);
            left = Math.min(left, bloomDay[i]);
        }
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int count = 0;
            int tm = m;
            for (int j = 0; j < len; j++) {
                if (k * tm - count > len - j) {
                    break;
                }
                if (bloomDay[j] > mid) {
                    count = 0;
                    continue;
                }
                count++;
                if (count == k) {
                    tm--;
                    count = 0;
                }
                if (tm == 0) {
                    break;
                }
            }
            if (tm > 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
