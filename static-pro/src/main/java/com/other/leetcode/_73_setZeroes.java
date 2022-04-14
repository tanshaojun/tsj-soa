package com.other.leetcode;

/**
 * 73. 矩阵置零
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/13 15:45
 */
public class _73_setZeroes {

    public void setZeroes(int[][] matrix) {

        int a = matrix.length;
        int b = matrix[0].length;
        boolean flags1 = false;
        boolean flags2 = false;

        for (int i = 1; i < a; i++) {
            if (matrix[i][0] == 0) {
                flags1 = true;
                break;
            }
        }

        for (int i = 1; i < b; i++) {
            if (matrix[0][i] == 0) {
                flags2 = true;
                break;
            }
        }

        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < a; i++)
            if (matrix[i][0] == 0) for (int j = 1; j < b; j++) matrix[i][j] = 0;

        for (int i = 1; i < b; i++)
            if (matrix[0][i] == 0) for (int j = 1; j < a; j++) matrix[j][i] = 0;

        if (flags1) for (int i = 0; i < a; i++) matrix[i][0] = 0;
        if (flags2) for (int i = 0; i < b; i++) matrix[0][i] = 0;

    }
}
