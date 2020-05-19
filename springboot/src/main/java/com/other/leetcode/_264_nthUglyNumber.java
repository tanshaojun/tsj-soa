package com.other.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. 丑数 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/19 14:46
 */
public class _264_nthUglyNumber {


    /**
     * 3指针
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int a = 0, b = 0, c = 0, min;
        for (int i = 1; i < res.length; i++) {
            min = Math.min(Math.min(res[a] * 2, res[b] * 3), res[c] * 5);
            res[i] = min;
            if (min == res[a] * 2) a++;
            if (min == res[b] * 3) b++;
            if (min == res[c] * 5) c++;
        }
        return res[n - 1];
    }

    /**
     * 堆解法
     *
     * @param n
     * @return
     */
    public int nthUglyNumber1(int n) {
        Set<Long> set = new HashSet<>();
        int[] res = new int[n];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        set.add(1L);
        long a, b;
        int[] primes = new int[]{2, 3, 5};
        for (int i = 0; i < res.length; i++) {
            a = pq.poll();
            res[i] = (int) a;
            for (int prime : primes) {
                b = prime * a;
                if (!set.contains(b)) {
                    pq.add(b);
                    set.add(b);
                }
            }
        }
        return res[n - 1];
    }
}
