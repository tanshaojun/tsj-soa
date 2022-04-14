package com.other.leetcode;

import java.util.Arrays;

/**
 * 面试题40. 最小的k个数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/14 11:56
 */
public class m40_getLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}
