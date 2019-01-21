package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;

public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int a : nums) {
            if (map.get(a) != null) return true;
            map.put(a, a);
        }
        return false;
    }
}
