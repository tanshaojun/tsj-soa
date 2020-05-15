package com.other.leetcode;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/15 15:54
 */
public class _1046_lastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() != 1) {
            Integer a = pq.poll();
            Integer b = pq.poll();
            if (!Objects.equals(a, b)) {
                pq.add(a - b);
            }
            if (pq.size() == 0) return 0;
        }
        return pq.poll();
    }

}
