package com.other.leetcode;

/**
 * 48. 旋转图像
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/13 14:59
 */
public class _48_Rotate {

    public static void main(String[] args) {
        rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
    }

    public static void rotate(int[][] matrix) {
        int abs1 = 0;
        int abs2 = matrix.length - 1;
        while (abs1 <= abs2) {
            int p1 = abs1;
            int p2 = abs2;
            while (p1 != abs2) {
                //左上
                int temp = matrix[abs1][p1];
                //左上 = 左下
                matrix[abs1][p1] = matrix[p2][abs1];
                //左下 = 右下
                matrix[p2][abs1] = matrix[abs2][p2];
                //右下 = 右上
                matrix[abs2][p2] = matrix[p1][abs2];
                //右上 = 左上
                matrix[p1][abs2] = temp;
                p1 += 1;
                p2 -= 1;
            }
            abs1 += 1;
            abs2 -= 1;
        }
    }
}
