package com.other.leetcode;

/**
 * 463. 岛屿的周长
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/9 14:43
 */
public class _463_islandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) res--;
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) res--;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) res--;
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) res--;
                }
            }
        }
        return res;
    }

}
