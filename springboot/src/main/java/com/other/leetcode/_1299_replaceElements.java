package com.other.leetcode;

/**
 * 1299. 将每个元素替换为右侧最大元素
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/3 15:14
 */
public class _1299_replaceElements {


    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(tmp, max);
        }
        return arr;
    }


}
