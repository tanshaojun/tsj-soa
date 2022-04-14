package com.other.leetcode;

/**
 * 1031. 两个非重叠子数组的最大和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/13 16:55
 */
public class _1031_maxSumTwoNoOverlap {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < L; i++) sum += A[i];
        max = Math.max(max, sum + add(0, L, M, A));
        for (int i = L; i < A.length; i++) {
            sum = sum + A[i] - A[i - L];
            max = Math.max(max, sum + add(i - L + 1, i + 1, M, A));
        }
        return max;
    }

    private int add(int L, int R, int M, int[] A) {
        int res = 0;
        if (L >= M) {
            int sum = 0;
            for (int i = 0; i < M; i++)
                sum += A[i];
            res = Math.max(res, sum);
            for (int i = M; i < L; i++) {
                sum = sum + A[i] - A[i - M];
                res = Math.max(res, sum);
            }
        }
        if (A.length - R > M) {
            int sum = 0;
            for (int i = R; i < R + M; i++)
                sum += A[i];
            res = Math.max(res, sum);
            for (int i = R + M; i < A.length; i++) {
                sum = sum + A[i] - A[i - M];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

}
