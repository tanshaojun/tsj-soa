package com.other.leetcode;

/**
 * 837. 新21点
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/3 10:10
 */
public class _837_new21Game {

    public double new21Game(int N, int K, int W) {
        if (K == 0) return 1.0;
        double[] dp = new double[K + W + 1];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        //从后往前计算，加入K=10时 前面9次取得最少的值的和为9，即选的都是1，
        // 每一次的选择为：前面选择的最小和加上第10次选择并且相加小于N的
        for (int k = K - 1; k >= 0; k--) {
            for (int i = 1; i <= W; i++) {
                System.out.println("k:" + k + ",i:" + i + "," + dp[k + i] / W);
                dp[k] += dp[k + i] / W;
            }
        }
        return dp[0];
    }

}
