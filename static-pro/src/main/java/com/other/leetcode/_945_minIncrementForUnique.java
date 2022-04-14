package com.other.leetcode;

/**
 * 945. 使数组唯一的最小增量
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/26 16:16
 */
public class _945_minIncrementForUnique {

    public int minIncrementForUnique(int[] A) {
        int[] tmp = new int[80000];
        for (int i = 0; i < A.length; i++) {
            tmp[A[i]] += 1;
        }
        int res = 0;
        for (int i = 0; i < tmp.length; i++) {
            int a = tmp[i];
            if (a > 1) {
                tmp[i + 1] += (a - 1);
                res += (a - 1);
            }
        }
        return res;
    }
}
