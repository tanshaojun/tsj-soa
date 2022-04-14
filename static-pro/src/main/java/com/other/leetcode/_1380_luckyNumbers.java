package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1380. 矩阵中的幸运数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/28 16:32
 */
public class _1380_luckyNumbers {
    public static void main(String[] args) {
        System.out.println(luckyNumbers(new int[][]{
                {7, 8},
                {1, 2}

        }));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;

        int[] mins = new int[x];
        int[] maxs = new int[y];
        for (int i = 0; i < x; i++) {
            mins[i] = Integer.MAX_VALUE;
            for (int j = 0; j < y; j++) {
                mins[i] = Math.min(mins[i], matrix[i][j]);
                maxs[j] = Math.max(maxs[j], matrix[i][j]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] >= maxs[j] && matrix[i][j] <= mins[i]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}
