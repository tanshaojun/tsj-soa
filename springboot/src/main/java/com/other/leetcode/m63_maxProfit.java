package com.other.leetcode;

/**
 * 面试题63. 股票的最大利润
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/9 17:05
 */
public class m63_maxProfit {

    public int maxProfit(int[] prices) {
        if (null == prices || 0 == prices.length) return 0;
        int res = 0;
        int b = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - b);
            b = Math.min(b, prices[i]);
        }
        return res;
    }

}
