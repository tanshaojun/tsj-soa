package com.other.leetcode;

import java.util.Arrays;

/**
 * 1833. 雪糕的最大数量
 *
 * @Author tansj
 * @Date 2021-05-11 10:37
 * @Version 1.0
 */
public class _1833_maxIceCream {

    public int maxIceCream(int[] costs, int coins) {
        int res = 0;
        Arrays.sort(costs);
        for (int i = 0; i < costs.length; i++) {
            if (coins - costs[i] < 0) {
                return res;
            }
            coins -= costs[i];
            res++;
        }
        return res;
    }

}
