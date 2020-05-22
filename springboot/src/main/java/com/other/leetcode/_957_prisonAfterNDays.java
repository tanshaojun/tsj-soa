//package com.other.leetcode;
//
///**
// * 957. N 天后的牢房
// *
// * @author tanshaojun
// * @version 1.0
// * @date 2020/5/22 17:34
// */
//public class _957_prisonAfterNDays {
//
//    public static void main(String[] args) {
//        int[] ints = prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000);
//        System.out.println(ints);
//    }
//
//    public static int[] prisonAfterNDays(int[] cells, int N) {
//        int y = cells.length;
//        int[][] dp = new int[N + 1][y];
//        for (int i = 0; i < y; i++) dp[0][i] = cells[i];
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j < y - 1; j++) {
//                if (dp[i - 1][j - 1] == dp[i - 1][j + 1]) dp[i][j] = 1;
//            }
//        }
//        return dp[N];
//    }
//}
