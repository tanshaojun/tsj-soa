package com.other.leetcode;

/**
 * 1351. 统计有序矩阵中的负数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/23 17:42
 */
public class _1351_countNegatives {

    public int countNegatives(int[][] grid) {
        int res = 0;
        int x = grid.length;
        int y = grid[0].length;
        int tmp = y;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] < 0) {
                    res += (x - i) * (tmp - j);
                    y -= (tmp - j);
                    tmp = y;
                }
            }
        }
        return res;
    }

}
