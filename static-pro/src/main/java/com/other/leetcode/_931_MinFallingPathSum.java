package com.other.leetcode;

/**
 * 931. 下降路径最小和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/31 9:33
 */
public class _931_MinFallingPathSum {

    public static int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int[] ints = A[i];
            min = Integer.MAX_VALUE;
            for (int j = 0; j < ints.length; j++) {
                int left = j - 1 >= 0 && i - 1 >= 0 ? A[i - 1][j - 1] + A[i][j] : Integer.MAX_VALUE;
                int mid = i - 1 >= 0 ? A[i - 1][j] + A[i][j] : A[i][j];
                int right = j + 1 < ints.length && i - 1 >= 0 ? A[i - 1][j + 1] + A[i][j] : Integer.MAX_VALUE;
                int m = Math.min(Math.min(left, mid), right);
                A[i][j] = m;
                if (m < min) min = m;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] ints = {
                {17, 82},
                {1, -44}
        };
        System.out.println(minFallingPathSum(ints));
    }
}
