package com.other.leetcode;

/**
 * 1217. 玩筹码
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/10/29 17:34
 */
public class _1217_MinCostToMoveChips {
    public int minCostToMoveChips(int[] chips) {
        int a = 0;
        int b = 0;
        for (int chip : chips) {
            if (chip % 2 == 0) a++;
            else b++;
        }
        return Math.min(a, b);
    }
}
