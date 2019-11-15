package com.other.leetcode;

/**
 * 985. 查询后的偶数和
 */
public class _985_sumEvenAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ints = new int[A.length];
        int s = 0;
        for (int j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) s += A[j];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (A[query[1]] % 2 == 0) s -= A[query[1]];
            A[query[1]] += query[0];
            if (A[query[1]] % 2 == 0) s += A[query[1]];
            ints[i] = s;
        }
        return ints;
    }
}
