package com.other.leetcode;

/**
 * 1414. 和为 K 的最少斐波那契数字数目
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/4 10:23
 */
public class _1414_findMinFibonacciNumbers {

    public int findMinFibonacciNumbers(int k) {
        int res = 0;
        while (k != 0) {
            res++;
            k = fib(k);
        }
        return res;
    }

    private int fib(int k) {
        int a = 1;
        int b = 1;
        int c = 0;
        while (c < k) {
            c = a + b;
            a = b;
            b = c;
        }
        return c > k ? k - a : 0;
    }

}
