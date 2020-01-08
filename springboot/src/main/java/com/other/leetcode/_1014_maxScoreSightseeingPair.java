package com.other.leetcode;

/**
 * 1014. 最佳观光组合
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/8 17:34
 */
public class _1014_maxScoreSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            res = Math.max(res, sum + A[i] - i);
            sum = Math.max(sum, A[i] + i);
        }
        return res;
    }

}
