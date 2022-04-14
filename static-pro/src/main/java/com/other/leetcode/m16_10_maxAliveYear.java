package com.other.leetcode;

/**
 * 面试题 16.10. 生存人数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/30 17:15
 */
public class m16_10_maxAliveYear {

    public int maxAliveYear(int[] birth, int[] death) {
        int[] dp = new int[102];
        for (int i = 0; i < birth.length; i++) {
            dp[birth[i] - 1900] += 1;
            dp[death[i] - 1900 + 1] -= 1;
        }
        int max = 0;
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1];
            if (dp[i] > max) {
                max = dp[i];
                res = i;
            }
        }
        return 1900 + res;
    }

    public int maxAliveYear1(int[] birth, int[] death) {
        int[] tmp = new int[101];
        for (int i = 0; i < birth.length; i++) {
            int start = birth[i] - 1900;
            int end = death[i] - 1900;
            for (int j = start; j <= end; j++) {
                tmp[j] += 1;
            }
        }
        int max = Integer.MIN_VALUE;
        int res = -1;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] > max) {
                max = tmp[i];
                res = i;
            }
        }
        return res + 1900;
    }

}
