package com.other.leetcode;

/**
 * 221. 最大正方形
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/12 9:59
 */
public class _221_maximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (null == matrix || matrix.length == 0) return 0;
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] dp = new int[x + 1][y + 1];
        int res = 0;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]
//                        + Integer.valueOf(String.valueOf(matrix[i - 1][j - 1]));
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

//        for (int i = 1; i <= x; i++) {
//            for (int j = 1; j <= y; j++) {
//                for (int k = res; i + k <= x && j + k <= y; k++) {
//                    int sum = dp[i + k][j + k] - dp[i + k][j - 1] - dp[i - 1][j + k] + dp[i - 1][j - 1];
//                    if (sum < (k + 1) * (k + 1)) break;
//                    res = Math.max(res, k + 1);
//                }
//            }
//        }
        return res * res;
    }
}
