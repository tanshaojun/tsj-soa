package com.other.leetcode;

/**
 * 840. 矩阵中的幻方
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/7 14:51
 */
public class _840_numMagicSquaresInside {

    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for (int i = 2; i < grid.length; i++) {
            for (int j = 2; j < grid[i].length; j++) {
                int a5 = grid[i - 2][j] + grid[i - 2][j - 1] + grid[i - 2][j - 2];
                int a4 = grid[i - 1][j] + grid[i - 1][j - 1] + grid[i - 1][j - 2];
                int a1 = grid[i][j] + grid[i][j - 1] + grid[i][j - 2];
                int a6 = grid[i][j - 1] + grid[i - 1][j - 1] + grid[i - 2][j - 1];
                int a7 = grid[i][j - 2] + grid[i - 1][j - 2] + grid[i - 2][j - 2];
                int a2 = grid[i][j] + grid[i - 1][j] + grid[i - 2][j];
                int a3 = grid[i][j] + grid[i - 1][j - 1] + grid[i - 2][j - 2];
                int a8 = grid[i][j - 2] + grid[i - 1][j - 1] + grid[i - 2][j];

                int a9 = grid[i - 2][j - 2] * grid[i - 2][j - 1] * grid[i - 2][j] *
                        grid[i - 1][j - 2] * grid[i - 1][j - 1] * grid[i - 1][j] *
                        grid[i][j - 2] * grid[i][j - 1] * grid[i][j];
                res += ((a9 == 362880) && (a1 == 15) && (a2 == 15) && (a3 == 15) && (a4
                        == 15) && (a5 == 15) && (a6 == 15) && (a7 == 15) && (a8 == 15) ? 1 : 0);
            }
        }
        return res;
    }
}
