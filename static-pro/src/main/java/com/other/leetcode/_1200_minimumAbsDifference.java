package com.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/3 16:15
 */
public class _1200_minimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i - 1] - arr[i]);
            if (diff < min) {
                res = new ArrayList<>();
                List<Integer> list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);
                res.add(list);
                min = diff;
            } else if (diff == min) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);
                res.add(list);
            }

        }
        return res;
    }
}
