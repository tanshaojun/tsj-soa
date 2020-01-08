package com.other.leetcode;

/**
 * 1277. 统计全为 1 的正方形子矩阵
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/6 15:32
 */
public class _1277_countSquares {
    public static void main(String[] args) {
        System.out.println(countSquares(new int[][]
                {
                        {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {0, 1, 1, 1}
                }
        ));
    }

    public static int countSquares(int[][] matrix) {
        int a = matrix.length;
        int b = matrix[0].length;
        int res = 0;
        int[][] dp = new int[a][b];
        for (int i = 0; i < a; i++)
            res += dp[i][0] = matrix[i][0];
        for (int i = 0; i < b; i++)
            res += dp[0][i] = matrix[0][i];
        if (matrix[0][0] == 1) res--;
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res += dp[i][j];
                }
            }
        }
        return res;

    }
}
