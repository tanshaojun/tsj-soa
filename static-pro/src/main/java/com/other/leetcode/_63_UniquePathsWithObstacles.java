package com.other.leetcode;

/**
 * 63. 不同路径 II
 */
public class _63_UniquePathsWithObstacles {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        }));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int colum = obstacleGrid.length;
        int row = obstacleGrid[0].length;
        int[][] ints = new int[colum][row];
        for (int i = 0; i < colum; i++) {
            int t = obstacleGrid[i][0];
            if (t == 1) {
                while (i < colum)
                    ints[i++][0] = 0;
            } else
                ints[i][0] = 1;
        }
        for (int i = 0; i < row; i++) {
            int t = obstacleGrid[0][i];
            if (t == 1) {
                while (i < row)
                    ints[0][i++] = 0;
            } else
                ints[0][i] = 1;
        }
        for (int i = 1; i < colum; i++) {
            for (int j = 1; j < row; j++) {
                int t = obstacleGrid[i][j];
                if (t == 1)
                    ints[i][j] = 0;
                else
                    ints[i][j] = ints[i - 1][j] + ints[i][j - 1];
            }
        }
        return ints[colum - 1][row - 1];
    }
}
