package com.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/15 9:52
 */
public class _90_subsetsWithDup {


    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        process(list, nums, 0);
        lists.add(new ArrayList<>());
        return lists;
    }

    private void process(List<Integer> list, int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            lists.add(new ArrayList<>(list));
            process(list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
