package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/7/24 17:55
 */
public class _1493_longestSubarray {

    public int longestSubarray(int[] nums) {
        if (null == nums) return 0;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                if (count != 0) {
                    list.add(count);
                    count = 0;
                }
                list.add(0);
            } else {
                count++;
            }
        }
        if (count != 0) list.add(count);
        if (list.size() == 1) {
            if (list.get(0) == 0) return 0;
            return nums.length - 1;
        }
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Integer pre = list.get(i - 1);
            Integer cur = list.get(i);
            Integer next = i + 1 < list.size() ? list.get(i + 1) : 0;
            max = Math.max(max, cur);
            if (pre > 0 && next > 0) {
                max = Math.max(max, pre + next);
            }
        }
        return max;
    }

}
