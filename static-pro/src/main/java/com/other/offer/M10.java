package com.other.offer;

public class M10 {

    /**
     * 斐波那契数列
     * <p>
     * 递归实现
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (0 == n || 1 == n) return n;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 斐波那契数列
     * <p>
     * 动态规划
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (0 == n || 1 == n) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * 斐波那契数列
     * <p>
     * 动态规划
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (0 == n || 1 == n) return n;
        int a = 1, b = 1, res = 1;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }


}
