package com.other.leetcode;

public class maxProfit {
    public static int maxProfit1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int t = prices[i];
            for (int j = 0 + i; j < prices.length; j++) {
                int t1 = prices[j];
                if (i != j) {
                    int tt = t1 - t;
                    if (tt > max)
                        max = tt;
                }
            }
        }
        return max;
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minNum = prices[0];
        int[] incomes = new int[prices.length];
        incomes[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minNum)
                minNum = prices[i];
            incomes[i] = prices[i] - minNum;
        }
        int maxIncome = 0;
        for (int i = 0; i < incomes.length; i++) {
            if (incomes[i] > maxIncome)
                maxIncome = incomes[i];
        }
        return maxIncome;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 1, 4, 3, 8}));
    }
}
