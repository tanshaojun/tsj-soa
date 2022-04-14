package com.other.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1726. 同积元组
 *
 * @Author tansj
 * @Date 2021-05-14 15:25
 * @Version 1.0
 */
public class _1726_tupleSameProduct {

    Map<Integer, Integer> map = new HashMap<>();

    int res = 0;

    public int tupleSameProduct(int[] nums) {
        process(nums, 0, new ArrayList<>());
        return res * 8;
    }

    private void process(int[] nums, int idx, List<Integer> list) {
        if (list.size() == 2) {
            int a = list.get(0);
            int b = list.get(1);
            int s = a * b;
            res += map.getOrDefault(s, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            process(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
