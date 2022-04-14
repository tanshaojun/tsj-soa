package com.other.leetcode;

/**
 * 1539. 第 k 个缺失的正整数
 *
 * @Author tansj
 * @Date 2021-05-14 10:55
 * @Version 1.0
 */
public class _1539_findKthPositive {
    public int findKthPositive(int[] arr, int k) {
        int start = 1;
        for (int i = 0; i < arr.length; i++) {
            while (start != arr[i]) {
                k--;
                if (k == 0) {
                    return start;
                }
                start++;
            }
            start++;
        }
        return arr[arr.length - 1] + k;
    }
}
