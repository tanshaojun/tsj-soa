package com.other.leetcode;

/**
 * 面试题 01.08. 零矩阵
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/15 10:22
 */
public class m01_08_setZeroes {

    public  void setZeroes(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        boolean[] xb = new boolean[x];
        boolean[] yb = new boolean[y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0 && (!xb[i] || !yb[j])) {
                    xb[i] = true;
                    yb[j] = true;
                }
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (xb[i] || yb[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
