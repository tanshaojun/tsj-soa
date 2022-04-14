package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 217. 存在重复元素
 */
public class _217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int a : nums) {
            if (map.get(a) != null) return true;
            map.put(a, a);
        }
        return false;
    }
}
