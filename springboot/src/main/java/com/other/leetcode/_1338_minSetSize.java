package com.other.leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1338. 数组大小减半
 *
 * @Author tansj
 * @Date 2021-05-14 11:20
 * @Version 1.0
 */
public class _1338_minSetSize {

    public int minSetSize(int[] arr) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Collection<Integer> values = map.values();
        List<Integer> collect = values.stream().sorted((a, b) -> -a.compareTo(b)).collect(Collectors.toList());
        int sum = 0;
        for (Integer i : collect) {
            sum += i;
            res++;
            if (sum >= (arr.length + 1) / 2) {
                return res;
            }
        }
        return res;
    }

}
