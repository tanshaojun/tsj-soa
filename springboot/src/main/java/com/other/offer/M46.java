package com.other.offer;

import java.util.Arrays;

public class M46 {


    /**
     * 把数字翻译成字符串,计算有多少种翻译方法
     *
     * @param n
     * @return
     */
    public int getTranslationCount(int n) {
        if (n < 10) return 1;
        char[] arr = String.valueOf(n).toCharArray();
        int[] dp = new int[arr.length];
        dp[0] = 1;
        dp[1] = ((arr[0] - '0') * 10 + (arr[1] - '0')) <= 25 ? 2 : 1;
        for (int i = 2; i < arr.length; i++) {
            dp[i] += dp[i - 1];
            int s = (arr[i - 1] - '0') * 10 + (arr[i] - '0');
            if (s >= 10 && s <= 25) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[dp.length - 1];
    }

}
