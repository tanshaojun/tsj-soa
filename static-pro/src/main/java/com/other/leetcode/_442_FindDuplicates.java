package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/1 17:36
 */
public class _442_FindDuplicates {
    public static void main(String[] args) {
        for (Integer integer : findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1})) {
            System.out.println(integer);
        }
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) ret.add(i + 1);
        }

        return ret;
    }

}
