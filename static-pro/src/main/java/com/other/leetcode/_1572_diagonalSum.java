package com.other.leetcode;

/**
 * 1572. 矩阵对角线元素的和
 *
 * @Author tansj
 * @Date 2021-05-12 16:13
 * @Version 1.0
 */
public class _1572_diagonalSum {

    public int diagonalSum(int[][] mat) {
        int x = mat.length;
        int y = mat[0].length;

        int a = 0;
        int b = 0;
        int res = 0;
        while (a < x && b < y) {
            res += mat[a][b];
            a++;
            b++;
        }

        a = 0;
        b = y - 1;
        while (a < x && b >= 0) {
            res += mat[a][b];
            a++;
            b--;
        }

        if (x % 2 == 1 && y % 2 == 1) {
            res -= mat[x / 2][y / 2];
        }

        return res;
    }

}
