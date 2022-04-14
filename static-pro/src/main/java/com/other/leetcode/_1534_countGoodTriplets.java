package com.other.leetcode;

/**
 * 1534. 统计好三元组
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/12 16:12
 */
public class _1534_countGoodTriplets {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        if (null == arr) return -1;
        int res = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) continue;
                for (int k = j + 1; k < arr.length; k++) {
                    int i_k = Math.abs(arr[i] - arr[k]);
                    int j_k = Math.abs(arr[j] - arr[k]);
                    if (i_k > c || j_k > b) continue;
                    res++;
                }
            }
        }
        return res;
    }

}
