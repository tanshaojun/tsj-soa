package com.other.offer;

public class M14 {


    /**
     * 剪绳子
     * 给你一根长度为n的绳子，请把绳子剪成m段（m，n都是整数 n>1并且m>1）每段绳子的长度为k[0],k[1]...k[m]
     * 请计算k[0]*k[1]*...*k[m]可能的最大乘积是多少
     * <p>
     * 动态规划
     *
     * @param n
     * @return
     */
    public int maxProductAfter(int n) {
        if (2 > n) return 0;
        if (2 == n) return 1;
        if (3 == n) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max;
        for (int i = 4; i <= n; i++) {
            max = 0;
            //f(i) = max(f(1)*f(i-1),f(2)*f(i-2),.....,f(i-1)*f(1))
            //f(5) = max(f(1)*f(4),f(2)*f(3),f(3)*(2),f(4)*f(1))
            //由于后面都是计算重的，所以j<=i/2就行
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(dp[j] * dp[i - j], max);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    /**
     * <p>
     * 贪心策略
     *
     * @param n
     * @return
     */
    public int maxProductAfter2(int n) {
        if (2 > n) return 0;
        if (2 == n) return 1;
        if (3 == n) return 2;
        int a = n / 3;
        if (n - a * 3 == 1) a--;
        int b = (n - a * 3) / 2;
        return (int) (Math.pow(3, a) * Math.pow(2, b));
    }
}
