package com.other.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 面试题 16.21. 交换和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/19 11:45
 */
public class m16_21_findSwapValues {

    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0;
        for (int i : array1) sum1 += i;
        for (int i : array2) sum2 += i;
        if (((sum1 + sum2) & 1) == 1) return new int[]{};
        int d = Math.abs(sum1 - sum2) / 2;
        Set<Integer> set = Arrays.stream(array2).boxed().collect(Collectors.toSet());
        for (int i : array2) set.add(i);
        for (int i : array1) {
            int a = Math.abs(i - d);
            if (sum1 < sum2) a = i + d;
            if (set.contains(a)) return new int[]{i, a};
        }
        return new int[]{};
    }

}
