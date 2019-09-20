package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/9/18 14:04
 */
public class _1018_PrefixesDivBy5 {
    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = ((sum << 1) + A[i]) % 5;
            list.add(sum == 0);
        }
        return list;
    }


    public static List<Boolean> prefixesDivBy51(int[] A) {
        List<Boolean> list = new ArrayList<>();
        int[] t = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            if (A[i] != 0) {
                t[i] = 1;
                sum = 1;
            }
            for (int j = 0; j < i; j++) {
                int tt = t[j];
                if (tt != 0) {
                    t[j] = tt * 2 % 10;
                    sum += t[j];
                }
            }
            if (sum % 5 == 0) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Boolean> booleans = prefixesDivBy5(new int[]{1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0});
        for (Boolean b : booleans) {
            System.out.println(b);
        }
    }
}
