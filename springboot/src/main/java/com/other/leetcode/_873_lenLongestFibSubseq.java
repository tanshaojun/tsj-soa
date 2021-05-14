package com.other.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 873. 最长的斐波那契子序列的长度
 *
 * @Author tansj
 * @Date 2021-05-14 11:38
 * @Version 1.0
 */
public class _873_lenLongestFibSubseq {

    public int lenLongestFibSubseq(int[] A) {
        int len = A.length;
        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < len; ++i)
            index.put(A[i], i);

        Map<Integer, Integer> longest = new HashMap();
        int ans = 0;

        for (int k = 0; k < len; ++k)
            for (int j = 0; j < k; ++j) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    int cand = longest.getOrDefault(i * len + j, 2) + 1;
                    longest.put(j * len + k, cand);
                    ans = Math.max(ans, cand);
                }
            }

        return ans >= 3 ? ans : 0;
    }

    int max = 0;

    public int lenLongestFibSubseq1(int[] arr) {
        List<Integer> list = new ArrayList<>();
        process(arr, 0, list);
        return max;
    }

    private void process(int[] arr, int idx, List<Integer> list) {
        if (list.size() >= 3 && list.get(list.size() - 1) != list.get(list.size() - 2) + list.get(list.size() - 3)) {
            return;
        }
        if (list.size() >= 3) {
            max = Math.max(max, list.size());
        }
        for (int i = idx; i < arr.length; i++) {
            list.add(arr[i]);
            process(arr, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
