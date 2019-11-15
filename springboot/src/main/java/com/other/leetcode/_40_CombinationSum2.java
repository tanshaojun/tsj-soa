package com.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/14 9:45
 */
public class _40_CombinationSum2 {


    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    private static List<List<Integer>> lists = new ArrayList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        f(0, candidates, target, list);
        return lists;
    }

    private static void f(int start, int[] candidates, int target, List<Integer> list) {
        if (target < 0) return;
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            f(i + 1, candidates, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}
