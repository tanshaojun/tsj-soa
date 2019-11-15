package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/14 17:49
 */
public class _46_permute {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] flags = new int[nums.length];
        process(nums, flags);
        return result;
    }

    private void process(int[] nums, int[] flags) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flags[i] == 1) continue;
            temp.add(nums[i]);
            flags[i] = 1;
            process(nums, flags);
            flags[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }
}
