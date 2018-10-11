package com.other.leetcode;

public class minPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
                {1, 4, 8, 6, 2, 2, 1, 7},
                {4, 7, 3, 1, 4, 5, 5, 1},
                {8, 8, 2, 1, 1, 8, 0, 1},
                {8, 9, 2, 9, 8, 0, 8, 9},
                {5, 7, 5, 7, 1, 8, 5, 5},
                {7, 0, 9, 4, 5, 6, 5, 6},
                {4, 9, 9, 7, 9, 1, 9, 0}
        }));
    }

    public static int minPathSum(int[][] grid) {
        int column = grid.length, row = grid[0].length;
        int[][] dp = new int[column][row];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) dp[0][i] = grid[0][i] + dp[0][i - 1];
        for (int i = 1; i < column; i++) dp[i][0] = grid[i][0] + dp[i - 1][0];
        for (int i = 1; i < column; i++) {
            for (int j = 1; j < row; j++)
                dp[i][j] = grid[i][j] + (dp[i - 1][j] > dp[i][j - 1] ? dp[i][j - 1] : dp[i - 1][j]);
        }
        return dp[column - 1][row - 1];
    }
}
