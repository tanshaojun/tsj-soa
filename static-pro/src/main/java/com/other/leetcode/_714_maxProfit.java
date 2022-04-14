package com.other.leetcode;

/**
 * 714. 买卖股票的最佳时机含手续费
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/9 17:58
 */
public class _714_maxProfit {

    public int maxProfit(int[] prices, int fee) {
        if (null == prices || prices.length == 0) return 0;
        int len = prices.length;
        //不持有
        int no = 0;
        //持有
        int hold = -prices[0];
        for (int i = 1; i < len; i++) {
            int t = no;
            //第二天不持有
            //第一天不持有 no
            //第一天持有   hold + prices[i] - fee)
            no = Math.max(no, hold + prices[i] - fee);
            //第二天持有
            //第一天持有 hold
            //第一天不持有 t-prices[i]
            hold = Math.max(hold, t - prices[i]);
        }
        return no;
    }

}
