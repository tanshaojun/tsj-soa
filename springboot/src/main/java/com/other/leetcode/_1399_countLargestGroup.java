package com.other.leetcode;

import java.util.Objects;

/**
 * 1399. 统计最大组的数目
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/7 16:18
 */
public class _1399_countLargestGroup {

    public int countLargestGroup(int n) {
        int[] tmp = new int[n + 1];
        int[] count = new int[n + 1];
        int max = 1;
        for (int i = 1; i <= n; i++) {
            int a = i % 10;
            int b = i / 10;
            tmp[i] = a + tmp[b];
            max = Math.max(max, ++count[tmp[i]]);
        }
        int res = 0;
        for (int i : count) {
            if (Objects.equals(i, max)) {
                res++;
            }
        }
        return res;
    }

}
