package com.other.leetcode;

/**
 * 1227. 飞机座位分配概率
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/21 16:35
 */
public class _1227_nthPersonGetsNthSeat {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1 : 0.5;
    }
}
