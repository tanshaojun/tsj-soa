package com.other.leetcode;

/**
 * 769. 最多能完成排序的块
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/14 11:11
 */
public class _769_maxChunksToSorted {

    public int maxChunksToSorted(int[] arr) {
        int res = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) res++;
        }
        return res;
    }

}
