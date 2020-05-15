package com.other.leetcode;

import java.util.PriorityQueue;

/**
 * 面试题 17.14. 最小K个数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/15 16:14
 */
public class m17_14_smallestK {

    public int[] smallestK(int[] arr, int k) {
        if (0 == k || 0 == arr.length) return new int[]{};
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : arr) {
            pq.add(i);
            if (pq.size() > k)
                pq.poll();
        }
        int[] res = new int[k];
        while (!pq.isEmpty()) {
            res[k - pq.size()] = pq.poll();
        }
        return res;
    }

}
