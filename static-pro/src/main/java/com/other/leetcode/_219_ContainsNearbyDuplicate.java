package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 */
public class _219_ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean b = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                if (Math.max(Math.abs((map.get(nums[i]) - i)), k) == k)
                    return true;
                else map.put(nums[i], i);
            } else map.put(nums[i], i);
        }
        return b;
    }
}
