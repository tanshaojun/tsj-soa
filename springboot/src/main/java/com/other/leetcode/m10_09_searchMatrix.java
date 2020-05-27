package com.other.leetcode;

/**
 * 面试题 10.09. 排序矩阵查找
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/26 11:17
 */
public class m10_09_searchMatrix {
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (null == matrix || 0 == matrix.length) return false;
        int x = matrix.length;
        int y = matrix[0].length;
        int a = 0;
        int b = y - 1;
        while (a < x && b >= 0) {
            if (matrix[a][b] > target) {
                b--;
            } else if (matrix[a][b] < target) {
                a++;
            } else {
                return true;
            }
        }
        return false;
    }
}
