package com.other.leetcode;

/**
 * 面试题46. 把数字翻译成字符串
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/9 9:44
 */
public class m46_translateNum {

    public int translateNum(int num) {
        if (0 == num) return 0;
        if (num < 10) return 1;
        char[] c = String.valueOf(num).toCharArray();
        int[] dp = new int[c.length];
        dp[0] = 1;
        dp[1] = c[1] != 0 && ((c[0] - '0') * 10 + (c[1] - '0')) <= 25 ? 2 : 1;
        for (int i = 2; i < c.length; i++) {
            dp[i] += dp[i - 1];
            if (c[i - 1] != '0' && ((c[i - 1] - '0') * 10 + (c[i] - '0')) <= 25) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[dp.length - 1];
    }

}
