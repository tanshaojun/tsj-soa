package com.other.leetcode;

import java.util.Arrays;

/**
 * 1128. 等价多米诺骨牌对的数量
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/7 14:35
 */
public class _1128_numEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[] cp = new int[100];
        for (int[] arr : dominoes) {
            Arrays.sort(arr);
            ans += cp[arr[0] * 10 + arr[1]]++;
        }
        return ans;
    }
}
