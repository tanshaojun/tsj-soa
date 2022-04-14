package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1481. 不同整数的最少数目
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/12 16:38
 */
public class _1481_findLeastNumOfUniqueInts {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (null == arr) return 0;
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        AtomicInteger total = new AtomicInteger(map.size());
        AtomicInteger sum = new AtomicInteger();
        map.values().stream().sorted().forEach(a -> {
            sum.addAndGet(a);
            if (sum.get() <= k) {
                total.getAndDecrement();
            } else {
                return;
            }
        });
        return total.get();
    }

}
