package com.other.leetcode;

/**
 * 413. 等差数列划分
 */
public class _413_NumberOfArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] A) {
        int sum = 0, s = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                s++;
                sum += s;
            } else {
                s = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }
}
