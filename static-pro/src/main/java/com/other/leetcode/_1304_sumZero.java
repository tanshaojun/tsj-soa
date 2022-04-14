package com.other.leetcode;

/**
 * 1304. 和为零的N个唯一整数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/3 15:00
 */
public class _1304_sumZero {

    public int[] sumZero(int n) {
        int[] res = new int[n];
        int b = n / 2;
        for (int i = 0; i < b; i++) {
            res[2 * i] = -(i + 1);
            res[2 * i + 1] = (i + 1);
        }
        return res;
    }

}
