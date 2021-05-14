package com.other.leetcode;

/**
 * 1588. 所有奇数长度子数组的和
 *
 * @Author tansj
 * @Date 2021-05-12 16:26
 * @Version 1.0
 */
public class _1588_sumOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int left_even = (left + 1) / 2;
            int left_odd = left / 2;

            int right = len - i;
            int right_even = (right + 1) / 2;
            int right_odd = right / 2;
            res = res + (left_odd * right_odd + left_even * right_even) * arr[i];
        }
        return res;
    }

    public int sumOddLengthSubarrays1(int[] arr) {
        int len = arr.length;
        int[] dp = new int[arr.length + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + arr[i - 1];
        }
        int res = 0;
        res += dp[len];
        int step = 3;
        while (step <= len) {
            for (int i = step; i <= len; i++) {
                res += (dp[i] - dp[i - step]);
            }
            step += 2;
        }
        return res;
    }

}
