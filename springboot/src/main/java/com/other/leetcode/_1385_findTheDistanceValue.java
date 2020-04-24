package com.other.leetcode;

/**
 * 1385. 两个数组间的距离值
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/23 17:28
 */
public class _1385_findTheDistanceValue {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        a:
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) continue a;
            }
            res++;
        }
        return res;
    }
}
