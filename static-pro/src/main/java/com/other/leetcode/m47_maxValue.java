package com.other.leetcode;

/**
 * 面试题47. 礼物的最大价值
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/26 14:53
 */
public class m47_maxValue {

    public int maxValue(int[][] grid) {
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] = Math.max(grid[i][j] + grid[i - 1][j], grid[i][j] + grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
