package com.other.leetcode;

import java.util.Arrays;

/**
 * 949. 给定数字能组成的最大时间
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/315:12
 */
public class _949_largestTimeFromDigits {
    public static String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        for (int i = 3; i >= 0; i--) {
            if (A[i] > 2) continue;
            for (int j = 3; j >= 0; j--) {
                if (j == i || A[i] == 2 && A[j] > 3) continue;
                for (int k = 3; k >= 0; k--) {
                    if (k == i || k == j || A[k] > 5) continue;
                    return "" + A[i] + A[j] + ':' + A[k] + A[6 - i - j - k];
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{1, 2, 3, 4}));
    }
}
