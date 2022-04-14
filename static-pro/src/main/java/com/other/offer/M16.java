package com.other.offer;

public class M16 {


    /**
     * 数值的整数次方
     * <p>
     * 实现函数double power(double base, int n) 求base的n次方，不得使用库函数，同时不需要考虑大数问题
     *
     * @param base
     * @param n
     * @return
     */
    public double power(double base, int n) {
        if (0 == base) {
            return base;
        }
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        double res = 1;
        for (int i = 0; i < n; i++) {
            res *= base;
        }
        return flag ? 1 / res : res;

    }


    /**
     * base 的 n 次方
     * res *=t                      n=1
     * t=base^8 = base^4 * base^4   n=2
     * t=base^4 = base^2 * base^2   n=4
     * t=base^2 = base * base       n=8
     * 只有当n为奇数时才相乘res
     *
     * @param base
     * @param n
     * @return
     */
    public double power1(double base, int n) {
        if (0 == base) {
            return base;
        }
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        double res = 1;
        double t = base;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= t;
            }
            t *= t;
            n >>= 1;
        }
        return flag ? 1 / res : res;
    }

}
