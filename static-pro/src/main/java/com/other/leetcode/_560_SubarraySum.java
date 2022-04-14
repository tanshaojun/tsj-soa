package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 */
public class _560_SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>(16);
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) count++;
            if (i == nums.length - 1 && index != nums.length - 1) {
                i = index++;
                sum = 0;
            }
        }
        return count;
    }

}
