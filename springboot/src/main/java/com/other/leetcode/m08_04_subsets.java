package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.04. 幂集
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/28 14:08
 */
public class m08_04_subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        add(nums, 0, res, list);
        return res;
    }

    private void add(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            add(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }


}
