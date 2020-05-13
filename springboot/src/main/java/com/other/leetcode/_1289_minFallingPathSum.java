package com.other.leetcode;

/**
 * 1289. 下降路径最小和  II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/13 14:23
 */
public class _1289_minFallingPathSum {

    public int minFallingPathSum(int[][] arr) {
        int x = arr.length;
        int y = arr[0].length;
        int[][] dp = new int[x][y];
        for (int j = 0; j < y; j++) {
            dp[0][j] = arr[0][j];
        }
        for (int i = 1; i < x; i++) {
            for (int j = 0; j < y; j++) {

                //找到上一轮相加的最小值
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < y; k++) {
                    if (j != k) min = Math.min(min, dp[i - 1][k]);
                }

                //用最小值加上当前值
                dp[i][j] = min + arr[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < y; i++) {
            res = Math.min(res, dp[x - 1][i]);
        }
        return res;
    }

}
