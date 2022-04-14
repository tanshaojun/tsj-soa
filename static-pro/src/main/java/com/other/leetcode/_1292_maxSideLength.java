package com.other.leetcode;

/**
 * 1292. 元素和小于等于阈值的正方形的最大边长
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/11 15:31
 */
public class _1292_maxSideLength {

    /**
     * 前缀和求解
     *
     * @param mat
     * @param threshold
     * @return
     */
    public int maxSideLength(int[][] mat, int threshold) {
        int x = mat.length;
        int y = mat[0].length;
        int[][] dp = new int[x][y];
        dp[0][0] = mat[0][0];
        for (int i = 1; i < x; i++)
            dp[i][0] = dp[i - 1][0] + mat[i][0];
        for (int j = 1; j < y; j++)
            dp[0][j] = dp[0][j - 1] + mat[0][j];
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + mat[i][j] - dp[i - 1][j - 1];
            }
        }
        int res = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int a = res; (i + a) < x && (j + a) < y; a++) {
                    int sum = dp[i + a][j + a];
                    if ((j - 1) >= 0) sum -= dp[i + a][j - 1];
                    if ((i - 1) >= 0) sum -= dp[i - 1][j + a];
                    if ((i - 1 >= 0) && (j - 1) >= 0) sum += dp[i - 1][j - 1];
                    if (sum > threshold) break;
                    res = Math.max(res, a + 1);
                }
            }
        }
        return res;
    }
}
