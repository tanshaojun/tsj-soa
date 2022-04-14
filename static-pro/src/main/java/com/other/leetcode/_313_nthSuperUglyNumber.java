package com.other.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 313. 超级丑数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/19 15:56
 */
public class _313_nthSuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int[] res = new int[n];
        set.add(1L);
        pq.add(1L);
        long a, b;
        for (int i = 0; i < res.length; i++) {
            a = pq.poll();
            res[i] = (int) a;
            for (int prime : primes) {
                b = a * prime;
                if (!set.contains(b)) {
                    set.add(b);
                    pq.add(b);
                }
            }
        }
        return res[n - 1];
    }

}
