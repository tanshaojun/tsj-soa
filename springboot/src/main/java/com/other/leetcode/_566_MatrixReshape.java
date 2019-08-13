package com.other.leetcode;

/**
 * 566. 重塑矩阵
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/8/6 19:33
 */
public class _566_MatrixReshape {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int x = nums.length;
        int y = nums[0].length;
        if (x * y == r * c) {
            int[][] result = new int[r][c];
            int a = 0;
            int b = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    result[a][b++] = nums[i][j];
                    if (b == c) {
                        b = 0;
                        a++;
                    }
                }
            }
            return result;
        }
        return nums;
    }

    public static void main(String[] args) {
        matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
    }

}
