package com.other.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/27 17:35
 */
public class _454_fourSumCount {

    /**
     * O(n^2)
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> aa = new HashMap<>(16);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int ab = A[i] + B[j];
                aa.put(ab, aa.getOrDefault(ab, 0) + 1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int diff = 0 - C[i] - D[j];
                res += aa.getOrDefault(diff, 0);
            }
        }
        return res;
    }

    /**
     * O(n^3)超时
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        Map<Integer, Integer> dd = new HashMap<>(16);
        for (int d : D) {
            dd.put(d, dd.getOrDefault(d, 0) + 1);
        }
        Map<Integer, Integer> bb = new HashMap<>(16);
        Map<Integer, Integer> cc = new HashMap<>(16);
        for (int i = 0; i < A.length; i++) {
            int tt = res;
            int b_c_d_diff = 0 - A[i];
            if (bb.containsKey(b_c_d_diff)) {
                res += bb.get(b_c_d_diff);
                continue;
            }
            for (int j = 0; j < B.length; j++) {
                int t = res;
                int c_d_diff = 0 - A[i] - B[j];
                if (cc.containsKey(c_d_diff)) {
                    res += cc.get(c_d_diff);
                    continue;
                }
                for (int c = 0; c < C.length; c++) {
                    int d_diff = 0 - A[i] - B[j] - C[c];
                    res += dd.getOrDefault(d_diff, 0);
                }
                cc.put(c_d_diff, res - t);
            }
            bb.put(b_c_d_diff, res - tt);
        }
        return res;
    }

}
