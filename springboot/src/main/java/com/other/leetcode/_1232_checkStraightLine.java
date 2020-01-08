package com.other.leetcode;


/**
 * 1232. 缀点成线
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/7 11:42
 */
public class _1232_checkStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 1; i < coordinates.length; i++) {
            if ((coordinates[1][0] - coordinates[0][0]) * (coordinates[i][1] - coordinates[0][1])
                    !=
                    (coordinates[i][0] - coordinates[0][0]) * (coordinates[1][1] - coordinates[0][1])) {
                return false;
            }
        }
        return true;
    }
}
