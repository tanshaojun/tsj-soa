package com.other.leetcode;

/**
 * 495. 提莫攻击
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/14 14:43
 */
public class _495_FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i + 1 < timeSeries.length) {
                if (timeSeries[i] + duration >= timeSeries[i + 1])
                    sum += (timeSeries[i + 1] - timeSeries[i]);
                else sum += duration;
            } else sum += duration;
        }
        return sum;
    }
}
