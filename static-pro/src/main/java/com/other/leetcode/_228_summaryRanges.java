package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/7 9:46
 */
public class _228_summaryRanges {


    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i, j = 0; j < nums.length; j++) {
            i = j;
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                j++;
            if (i == j)
                res.add(String.valueOf(nums[i]));
            else
                res.add(nums[i] + "->" + nums[j]);
        }
        return res;
    }

    public List<String> summaryRanges1(int[] nums) {
        List<String> res = new ArrayList<>();
        if (null == nums || nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int index = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            long diff = Long.valueOf(nums[i]) - Long.valueOf(nums[i - 1]);
            if (diff > 1) {
                if (count > 1) {
                    res.add(nums[index] + "->" + nums[i - 1]);
                } else {
                    res.add(String.valueOf(nums[index]));
                }
                index = i;
                count = 1;
            } else {
                count++;
            }
        }
        if (count > 1) {
            res.add(nums[index] + "->" + nums[nums.length - 1]);
        } else {
            res.add(String.valueOf(nums[index]));
        }
        return res;
    }
}
