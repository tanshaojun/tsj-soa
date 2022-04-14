package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/10/29 15:28
 */
public class _78_Subsets {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3};
        List<Integer> pre = new ArrayList<>();
        find(ints, 0, pre);
    }

    private static List<List<Integer>> res = new ArrayList<>();

    /**
     * DFS
     *
     * @param nums
     * @param begin
     * @param pre
     */
    private static void find(int[] nums, int begin, List<Integer> pre) {
        System.out.println(pre);
        res.add(new ArrayList<>(pre));
        for (int i = begin; i < nums.length; i++) {
            pre.add(nums[i]);
            find(nums, i + 1, pre);
            // 组合问题，状态在递归完成后要重置
            pre.remove(pre.size() - 1);
        }
    }


    /**
     * 追加
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }
        return result;
    }
}
