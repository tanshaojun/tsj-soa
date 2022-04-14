package com.other.leetcode;

/**
 * 1252. 奇数值单元格的数目
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/13 14:24
 */
public class _1252_OddCells {

    public static void main(String[] args) {
        System.out.println(oddCells(1, 1, new int[][]{{0, 0}, {0, 0}}));
    }


    public static int oddCells(int n, int m, int[][] indices) {
        int[] x = new int[n];
        int[] y = new int[m];
        for (int i = 0; i < indices.length; i++) {
            int[] index = indices[i];
            x[index[0]] += 1;
            y[index[1]] += 1;
        }

        int[][] ints = new int[n][m];

        for (int i = 0; i < x.length; i++) {
            if (x[i] != 0) {
                for (int j = 0; j < m; j++) {
                    ints[i][j] += x[i];
                }
            }
        }

        for (int i = 0; i < y.length; i++) {
            if (y[i] != 0) {
                for (int j = 0; j < n; j++) {
                    ints[j][i] += y[i];

                }
            }
        }

        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (ints[i][j] % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }


}
