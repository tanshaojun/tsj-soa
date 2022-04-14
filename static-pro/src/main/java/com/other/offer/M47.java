package com.other.offer;

public class M47 {


    /**
     * 礼物的最大价值
     * <p>
     * f(i,j)=max(f(i-1,j),f(i,j-1))+arr[i][j]
     *
     * @param arr
     * @return
     */
    public int getMaxValue_solution(int[][] arr) {
        if (null == arr || 0 == arr.length) return 0;
        int x = arr.length;
        int y = arr[0].length;

        int[][] dp = new int[x][y];

        dp[0][0] = arr[0][0];

        for (int i = 1; i < x; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }

        for (int j = 1; j < y; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[x - 1][y - 1];
    }


}
