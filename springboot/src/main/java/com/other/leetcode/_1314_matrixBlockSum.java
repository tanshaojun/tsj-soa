package com.other.leetcode;

/**
 * 1314. 矩阵区域和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/11 14:10
 */
public class _1314_matrixBlockSum {
    public static void main(String[] args) {
        matrixBlockSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 1);
    }

    /**
     * dp解法
     *
     * @param mat
     * @param K
     * @return
     */
    public static int[][] matrixBlockSum(int[][] mat, int K) {
        int x = mat.length;
        int y = mat[0].length;
        int[][] dp = new int[x][y];
        dp[0][0] = mat[0][0];
        for (int i = 1; i < x; i++) {
            dp[i][0] = dp[i - 1][0] + mat[i][0];
        }
        for (int j = 1; j < y; j++) {
            dp[0][j] = dp[0][j - 1] + mat[0][j];
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                //求前缀和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i][j];
            }
        }
        int[][] res = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int x1 = Math.min(i + K, x - 1);
                int y1 = Math.min(j + K, y - 1);
//                res[i][j] = dp[i + K][j + K] - dp[i + K][j - K - 1] - dp[i - K - 1][j + K] + dp[i - K - 1][j - K - 1];
                res[i][j] = dp[x1][y1];
                if ((j - K - 1) >= 0 && (i - K - 1) >= 0) res[i][j] += dp[i - K - 1][j - K - 1];
                if ((i - K - 1) >= 0) res[i][j] -= dp[i - K - 1][y1];
                if ((j - K - 1) >= 0) res[i][j] -= dp[x1][j - K - 1];
            }
        }
        return res;
    }

    /**
     * 暴力解法
     *
     * @param mat
     * @param K
     * @return
     */
    public static int[][] matrixBlockSum1(int[][] mat, int K) {
        int x = mat.length;
        int y = mat[0].length;
        int[][] res = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int a = (i - K) < 0 ? 0 : (i - K); a <= ((i + K) < x ? (i + K) : x - 1); a++) {
                    for (int b = (j - K) < 0 ? 0 : (j - K); b <= ((j + K) < y ? (j + K) : y - 1); b++) {
                        res[i][j] += mat[a][b];
                    }
                }
            }
        }
        return res;
    }
}
