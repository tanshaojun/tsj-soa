package com.other.leetcode;

/**
 * 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/4 9:44
 */
public class _1343_numOfSubarrays {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if (null == arr || 0 == arr.length || 0 == k) return 0;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                int avg = sum / k;
                if (avg >= threshold) {
                    res++;
                }
                sum -= arr[i - k + 1];
            }

        }
        return res;
    }


}
