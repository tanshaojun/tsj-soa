package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/14 13:57
 */
public class _77_Combine {
    public static void main(String[] args) {
        System.out.println(combine(0, 1));
    }


    private static List<List<Integer>> lists = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        process(n, list, k, 1);
        return lists;
    }

    private static void process(int n, List<Integer> list, int k, int start) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            process(n, list, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
