package com.other.leetcode;

/**
 * 1310. 子数组异或查询
 *
 * @Author tansj
 * @Date 2021-05-12 09:23
 * @Version 1.0
 */
public class _1310_xorQueries {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = dp[i - 1] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a == b) {
                res[i] = arr[a];
            } else if (a == 0) {
                res[i] = dp[b];
            } else {
                res[i] = dp[b] ^ dp[a - 1];
            }
        }
        return res;
    }

}
