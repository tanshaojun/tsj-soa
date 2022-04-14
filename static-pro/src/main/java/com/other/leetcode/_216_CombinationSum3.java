package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/10/29 16:33
 */
public class _216_CombinationSum3 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> t = new ArrayList<>();
        f(10, 1, t, k, n, 0);
        return res;

    }

    /**
     * @param a 固定值 10
     * @param j 第几个数
     * @param t 计算集合
     * @param k
     * @param n
     * @param s 总和
     */
    private static void f(int a, int j, List<Integer> t, int k, int n, int s) {
        if (0 == k) {
            if (s == n) res.add(new ArrayList<>(t));
            return;
        }
        for (int i = j; i < a; i++) {
            t.add(i);
            f(a, i + 1, t, k - 1, n, s + i);
            t.remove(t.size() - 1);
        }
    }

}
