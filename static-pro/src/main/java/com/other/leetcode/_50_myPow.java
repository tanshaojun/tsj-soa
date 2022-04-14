package com.other.leetcode;

/**
 * 50. Pow(x, n) 即计算 x 的 n 次幂函数。
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/11 11:16
 */
public class _50_myPow {

    /**
     * x^n = x^1*x^(n-1)
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long a = n;
        if (a < 0) {
            a = -a;
            x = 1 / x;
        }
        double res = 1;
        double t = x;
        while (a > 0) {
            if ((a & 1) == 1) res *= t;
            t *= t;
            a = a >> 1;
        }
        return res;
    }
}
