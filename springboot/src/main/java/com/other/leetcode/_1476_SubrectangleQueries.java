package com.other.leetcode;

/**
 * 1476. 子矩形查询
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/15 17:56
 */
public class _1476_SubrectangleQueries {

    private int[][] rectangle = null;

    public _1476_SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }

}
