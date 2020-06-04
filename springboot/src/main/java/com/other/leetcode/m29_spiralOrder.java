package com.other.leetcode;

/**
 * 面试题29. 顺时针打印矩阵
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/3 16:17
 */
public class m29_spiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if (null == matrix || 0 == matrix.length) return new int[]{};
        int x = matrix.length;
        int y = matrix[0].length;
        int[] res = new int[x * y];
        int index = 0;

        int count = 0;
        while (count * 2 < x && count * 2 < y) {

            //从左到右
            for (int i = count; i < y - count; i++) {
                res[index++] = matrix[count][i];
            }

            //从上到下
            if (count < x - 1 - count) {
                for (int i = count + 1; i <= x - 1 - count; i++) {
                    res[index++] = matrix[i][y - 1 - count];
                }
            }

            //从右到左
            if (count < x - 1 - count && count < y - 1 - count) {
                for (int i = y - 1 - count - 1; i >= count; i--) {
                    res[index++] = matrix[x - 1 - count][i];
                }
            }

            //从下到上
            if (count < y - 1 - count && count < x - 1 - count - 1) {
                for (int i = x - 1 - count - 1; i >= count + 1; i--) {
                    res[index++] = matrix[i][count];
                }
            }

            count++;

        }
        return res;
    }

}
