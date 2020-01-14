package com.other.leetcode;

/**
 * 1052. 爱生气的书店老板
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/14 16:38
 */
public class _1052_maxSatisfied {


    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0;
        for (int i = 0; i < customers.length; i++)
            if (grumpy[i] == 0) res += customers[i];
        int sum = 0;
        for (int i = 0; i < X; i++)
            if (grumpy[i] == 1) sum += customers[i];
        int max = sum;
        for (int i = X; i < customers.length; i++) {
            sum = sum + (grumpy[i] == 1 ? customers[i] : 0) - (grumpy[i - X] == 1 ? customers[i - X] : 0);
            max = Math.max(max, sum);
        }
        return res + max;
    }
}
