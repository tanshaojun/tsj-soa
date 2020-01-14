package com.other.leetcode;

/**
 * 795. 区间子数组个数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/14 15:53
 */
public class _795_numSubarrayBoundedMax {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return numSubarrayBoundedMax(A, R) - numSubarrayBoundedMax(A, L - 1);
    }

    public int numSubarrayBoundedMax(int[] A, int R) {
        int res = 0;
        int count = 0;
        for (int i : A) {
            count = i <= R ? count + 1 : 0;
            res += count;
        }
        return res;
    }

    public int numSubarrayBoundedMax1(int[] A, int L, int R) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            int max = A[i];
            if (max > R) continue;
            if (max >= L && max <= R) {
                res++;
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] > R) break;
                    res++;
                }
            }
            if (max < L) {
                boolean b = false;
                for (int j = i + 1; j < A.length; j++) {
                    if (!b) if (A[j] < L) continue;
                    if (A[j] > R) break;
                    res++;
                    b = true;
                }

            }
        }
        return res;
    }

}
