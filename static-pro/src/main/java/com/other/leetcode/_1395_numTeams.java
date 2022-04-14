package com.other.leetcode;

/**
 * 1395. 统计作战单位数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/27 15:43
 */
public class _1395_numTeams {

    public int numTeams(int[] rating) {
        int res = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] > rating[i]) {
                    for (int k = j + 1; k < rating.length; k++) {
                        if (rating[k] > rating[j]) res++;
                    }
                }
                if (rating[j] < rating[i]) {
                    for (int k = j + 1; k < rating.length; k++) {
                        if (rating[k] < rating[j]) res++;
                    }
                }
            }
        }
        return res;
    }

}
