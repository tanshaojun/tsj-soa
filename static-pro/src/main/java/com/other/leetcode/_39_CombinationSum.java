package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/10/29 17:00
 */
public class _39_CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
    }

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        f(candidates, new ArrayList<>(), target, 0, 0);
        return res;
    }

    private static void f(int[] candidates, List<Integer> list, int target, int j, int s) {
        if (j >= candidates.length || s > target) return;
        if (s == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = j; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            list.add(candidates[i]);
            f(candidates, list, target, i, s + candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
