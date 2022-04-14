package com.other.leetcode;

/**
 * 面试题04. 二维数组中的查找
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/26 13:38
 */
public class m04_findNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
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
}
