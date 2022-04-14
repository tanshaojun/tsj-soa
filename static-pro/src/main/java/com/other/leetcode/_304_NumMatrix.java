package com.other.leetcode;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/26 15:48
 */
public class _304_NumMatrix {

    int[][] dp = null;
    int x = 0;
    int y = 0;

    /**
     * 前缀和
     *
     * @param matrix
     */
    public _304_NumMatrix(int[][] matrix) {
        if (matrix.length == 0) return;
        this.x = matrix.length;
        this.y = matrix[0].length;
        dp = new int[x][y];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < x; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < y; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 < 0 || row2 < 0 || col1 < 0 || col2 < 0 || row1 >= x || row2 >= x || col1 >= y || col2 >= y) {
            return -1;
        }
        int res = dp[row2][col2];
        if (col1 - 1 >= 0) {
            res -= dp[row2][col1 - 1];
        }
        if (row1 - 1 >= 0) {
            res -= dp[row1 - 1][col2];
        }
        if (col1 - 1 >= 0 && row1 - 1 >= 0) {
            res += dp[row1 - 1][col1 - 1];
        }
        return res;
    }
}
