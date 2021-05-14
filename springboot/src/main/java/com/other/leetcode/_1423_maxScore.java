package com.other.leetcode;

/**
 * 1423. 可获得的最大点数
 *
 * @Author tansj
 * @Date 2021-05-12 14:56
 * @Version 1.0
 */
public class _1423_maxScore {

    public int maxScore(int[] cardPoints, int k) {
        int s = 0;
        for (int i = 0; i < k; i++) {
            s += cardPoints[i];
        }
        int max = s;
        int len = cardPoints.length - 1;
        while (k > 0) {
            s = s - cardPoints[--k];
            s = s + cardPoints[len--];
            max = Math.max(max, s);
        }
        return max;
    }

}
