package com.other.leetcode;

/**
 * 1287. 有序数组中出现次数超过25%的元素
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/3 17:02
 */
public class _1287_findSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        int count = 1;
        int res = arr[0];
        int a = arr.length / 4;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == res) {
                count++;
                if (count > a) return res;
            } else {
                count = 1;
                res = arr[i];
            }
        }
        return res;
    }
}
