package com.other.leetcode;

/**
 * 670. 最大交换
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/4 15:11
 */
public class _670_maximumSwap {

    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char max = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (max < arr[j]) max = arr[j];
            }
            for (int k = arr.length - 1; k >= 0 && arr[i] != max; k--) {
                if (arr[k] == max) {
                    arr[k] = arr[i];
                    arr[i] = max;
                    return Integer.valueOf(new String(arr));
                }
            }
        }
        return num;
    }

}
