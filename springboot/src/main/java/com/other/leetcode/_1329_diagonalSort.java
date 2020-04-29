package com.other.leetcode;

import java.util.Arrays;

/**
 * 1329. 将矩阵按对角线排序
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/27 18:18
 */
public class _1329_diagonalSort {

    public int[][] diagonalSort(int[][] mat) {
        int a = mat.length;
        int b = mat[0].length;
        int[] tmp = new int[a * b];
        save(mat, a, b, tmp, 0);
        save(mat, a, b, tmp, 1);
        return mat;
    }

    private void save(int[][] mat, int a, int b, int[] tmp, int start) {
        for (int i = start; i < (start == 0 ? a : b); i++) {
            int index = 0;
            int y = 0;
            int x = i;
            while (x < a && y < b) {
                tmp[index++] = mat[x++][y++];
            }
            y = 0;
            x = i;
            Arrays.sort(tmp);
            for (int j = tmp.length - index; j < tmp.length; j++) {
                mat[x++][y++] = tmp[j];
                tmp[j] = 0;
            }
        }
    }

}
