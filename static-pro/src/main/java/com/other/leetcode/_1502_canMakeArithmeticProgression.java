package com.other.leetcode;

import java.util.Arrays;

/**
 * 1502. 判断能否形成等差数列
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/7/20 10:09
 */
public class _1502_canMakeArithmeticProgression {

    public boolean canMakeArithmeticProgression(int[] arr) {
        if (null == arr) return false;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (diff != arr[i] - arr[i - 1]) return false;
        }
        return true;
    }

}
