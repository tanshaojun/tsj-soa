package com.other.leetcode;

/**
 * 74. 搜索二维矩阵
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/25 17:50
 */
public class _74_searchMatrix {

    /**
     * 二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || 0 == matrix.length) return false;
        int x = matrix.length;
        int y = matrix[0].length;
        int left = 0;
        int right = x * y - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == matrix[mid / y][mid % y]) {
                return true;
            } else if (target > matrix[mid / y][mid % y]) {
                left = mid + 1;
            } else {
                right = mid - 1;
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
