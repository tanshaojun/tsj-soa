package com.other.leetcode;

/**
 * 240. 搜索二维矩阵 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/26 10:44
 */
public class _240_searchMatrix {

    /**
     * 每行二分
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || 0 == matrix.length) return false;
        int x = matrix.length;
        for (int i = 0; i < x; i++) {
            int left = 0;
            int right = matrix[i].length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

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
