package com.other.leetcode;

/**
 * 1375. 灯泡开关 III
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/3 19:04
 */
public class _1375_numTimesAllBlue {

    public int numTimesAllBlue(int[] light) {
        int res = 0;
        int max = 1;
        for (int i = 0; i < light.length; i++) {
            max = Math.max(max, light[i]);
            if (max == i + 1) {
                res++;
                max++;
            }
        }
        return res;
    }
}
