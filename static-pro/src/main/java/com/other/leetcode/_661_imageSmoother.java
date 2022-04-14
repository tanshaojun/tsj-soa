package com.other.leetcode;

import java.util.Arrays;

/**
 * 661. 图片平滑器
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/7 15:34
 */
public class _661_imageSmoother {
    public static void main(String[] args) {
        Arrays.deepToString(imageSmoother(new int[][]{
                {2, 3, 4},
                {5, 6, 7},
                {8, 9, 10}
        }));
    }

    public static int[][] imageSmoother(int[][] M) {
        int a = M.length;
        int b = M[0].length;
        int[][] res = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                int sum = M[i][j];
                int count = 1;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    sum += M[i - 1][j - 1];
                    count++;
                }
                if (i - 1 >= 0) {
                    sum += M[i - 1][j];
                    count++;
                }
                if (i - 1 >= 0 && j + 1 < b) {
                    sum += M[i - 1][j + 1];
                    count++;
                }
                if (j - 1 >= 0) {
                    sum += M[i][j - 1];
                    count++;
                }
                if (j + 1 < b) {
                    sum += M[i][j + 1];
                    count++;
                }
                if (i + 1 < a && j - 1 >= 0) {
                    sum += M[i + 1][j - 1];
                    count++;
                }
                if (i + 1 < a) {
                    sum += M[i + 1][j];
                    count++;
                }
                if (i + 1 < a && j + 1 < b) {
                    sum += M[i + 1][j + 1];
                    count++;
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
