package com.other.leetcode;

/**
 * 1828. 统计一个圆中点的数目
 *
 * @Author tansj
 * @Date 2022/4/14 5:11 下午
 * @Version 1.0
 */
public class _1828_countPoints {

    public int[] countPoints(int[][] points, int[][] queries) {
        int length = queries.length;
        int[] res = new int[length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];
            for (int[] point : points) {
                int x1 = point[0];
                int y1 = point[1];
                double sqrt = Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
                if (sqrt <= r) {
                    res[i]++;
                }
            }
        }
        return res;
    }

}
