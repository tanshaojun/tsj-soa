package com.other.leetcode;

/**
 * 59 螺旋矩阵 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/8/27 14:42
 */
public class _59_GenerateMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        int num = 1;
        int size = n;
        int x = 0;
        int y = 0;
        while (num <= n * n) {
            //右
            while (y < size) {
                ints[x][y++] = num++;
            }
            //下
            x++;
            y--;
            while (x < size) {
                ints[x++][y] = num++;
            }
            //左
            x--;
            y--;
            while (y >= n - size) {
                ints[x][y--] = num++;
            }
            //上
            y++;
            x--;
            while (x >= n - size) {
                if (ints[x][y] == 0) {
                    ints[x--][y] = num++;
                } else {
                    size--;
                    x++;
                    y++;
                    break;
                }
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        generateMatrix(10);
    }
}
