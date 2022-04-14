package com.other.leetcode;

import java.util.Stack;

/**
 * 1475. 商品折扣后的最终价格
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/15 15:51
 */
public class _1475_finalPrices {

    public int[] finalPrices(int[] prices) {
        if (null == prices || 0 == prices.length) return prices;
        int[] res = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                Integer p = stack.pop();
                res[p] = prices[p] - prices[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer p = stack.pop();
            res[p] = prices[p];
        }
        return res;

    }

}
