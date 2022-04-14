package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 532. 数组中的K-diff数对
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/9/23 17:37
 */
public class _532_FindPairs {

    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int count = 0;
        if (k < 0) return count;
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        for (int i : map.keySet()) {
            if (k == 0) {
                if (map.get(i) > 1)
                    count++;
            } else if (map.containsKey(i + k)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    }

}
