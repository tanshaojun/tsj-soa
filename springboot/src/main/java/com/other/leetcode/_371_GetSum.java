package com.other.leetcode;

/**
 * 371. 两整数之和
 */
public class _371_GetSum {
    public int getSum(int a, int b) {
        //取异或
        int r = a ^ b;
        //判断是否需要进位
        int f = (a & b) << 1;
        if (f != 0) {
            return getSum(r, f);
        }
        return r;
    }
}
