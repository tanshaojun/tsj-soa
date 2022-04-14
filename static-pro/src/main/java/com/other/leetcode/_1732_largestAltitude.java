package com.other.leetcode;

/**
 * 1732. 找到最高海拔
 *
 * @Author tansj
 * @Date 2021-05-12 17:03
 * @Version 1.0
 */
public class _1732_largestAltitude {

    public int largestAltitude(int[] gain) {
        int max = 0, first = 0;
        for (int i = 0; i < gain.length; i++) {
            int a = first + gain[i];
            max = Math.max(max, a);
            first = a;
        }
        return max;
    }

}
