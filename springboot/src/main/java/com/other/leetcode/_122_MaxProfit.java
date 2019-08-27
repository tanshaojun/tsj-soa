package com.other.leetcode;

/**
 * 买卖股票的最佳时机 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/8/27 14:25
 */
public class _122_MaxProfit {
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += (prices[i] - prices[i - 1]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
