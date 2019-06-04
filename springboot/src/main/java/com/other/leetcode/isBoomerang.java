package com.other.leetcode;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/314:17
 */
public class isBoomerang {

    public static boolean isBoomerang(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];

        return (y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1);
    }

    public static void main(String[] args) {
        System.out.println(isBoomerang(new int[][]{
                {1, 1},
                {2, 2},
                {3, 3}
        }));
    }
}
