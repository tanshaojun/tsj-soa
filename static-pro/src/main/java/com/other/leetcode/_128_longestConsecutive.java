package com.other.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/18 18:00
 */
public class _128_longestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (null == nums) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int t = num;
                int size = 1;
                while (set.contains(t + 1)) {
                    t++;
                    size++;
                }
                res = Math.max(res, size);
            }
        }
        return res;
    }

}
