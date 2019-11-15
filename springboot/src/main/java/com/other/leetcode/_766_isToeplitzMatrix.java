package com.other.leetcode;

/**
 * 766. 托普利茨矩阵
 */
public class _766_isToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;

        for (int i = 0; i < y; i++) {
            int a = 0;
            int b = i;
            int tmp = matrix[a][b];
            while (a < x && b < y) {
                if (tmp != matrix[a][b]) {
                    return false;
                }
                a++;
                b++;
            }
        }
        for (int i = 1; i < x; i++) {
            int a = i;
            int b = 0;
            int tmp = matrix[a][b];
            while (a < x && b < y) {
                if (tmp != matrix[a][b]) {
                    return false;
                }
                a++;
                b++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{
                {18,1},
                {1}
        }));
    }
}
