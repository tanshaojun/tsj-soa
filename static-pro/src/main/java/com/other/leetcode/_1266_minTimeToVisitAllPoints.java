package com.other.leetcode;

/**
 * 1266. 访问所有点的最小时间
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/3 13:47
 */
public class _1266_minTimeToVisitAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int x = points[0][0];
        int y = points[0][1];
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            res += Math.max(Math.abs(x - x1), Math.abs(y - y1));
            x = x1;
            y = y1;
        }
        return res;
    }

}
