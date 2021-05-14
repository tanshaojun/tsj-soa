package com.other.leetcode;

/**
 * 1672. 最富有客户的资产总量
 *
 * @Author tansj
 * @Date 2021-05-12 15:27
 * @Version 1.0
 */
public class _1672_maximumWealth {

    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int i = 0; i < accounts.length; i++) {
            int s = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                s += accounts[i][j];
            }
            res = Math.max(res, s);
        }
        return res;
    }

}
