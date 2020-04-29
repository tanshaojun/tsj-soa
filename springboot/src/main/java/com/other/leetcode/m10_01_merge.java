package com.other.leetcode;

import java.util.Arrays;

/**
 * 面试题 10.01. 合并排序的数组
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/29 17:09
 */
public class m10_01_merge {
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; i++) {
            A[m + i] = B[i];
        }
        Arrays.sort(A);
    }
}
