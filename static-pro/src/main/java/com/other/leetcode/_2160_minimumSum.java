package com.other.leetcode;

import java.util.Arrays;

/**
 * 2160. 拆分数位后四位数字的最小和
 *
 * @Author tansj
 * @Date 2022/4/21 16:04
 * @Version 1.0
 */
public class _2160_minimumSum {

    public int minimumSum(int num) {
        int[] r = new int[4];
        r[0] = num / 1000;
        r[1] = (num % 1000) / 100;
        r[2] = (num % 100) / 10;
        r[3] = num % 10;
        Arrays.sort(r);
        return r[0] * 10 + r[2] + r[1] * 10 + r[3];
    }

}
