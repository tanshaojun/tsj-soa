package com.other.leetcode;

/**
 * 695. 岛屿的最大面积
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/9 14:14
 */
public class _695_maxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, dfs(i, j, grid));
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int sum = 1;
        sum += dfs(i - 1, j, grid);
        sum += dfs(i + 1, j, grid);
        sum += dfs(i, j - 1, grid);
        sum += dfs(i, j + 1, grid);
        return sum;
    }
}
