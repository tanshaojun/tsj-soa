package com.other.leetcode;

/**
 * 1394. 找出数组中的幸运数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/30 17:02
 */
public class _1394_findLucky {

    public int findLucky(int[] arr) {
        int res = -1;
        int max = 0;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);
        int[] tmp = new int[max + 1];
        for (int i = 0; i < arr.length; i++)
            tmp[arr[i]] += 1;
        for (int i = tmp.length - 1; i > 0; i--)
            if (tmp[i] == i) return i;
        return res;
    }

}
