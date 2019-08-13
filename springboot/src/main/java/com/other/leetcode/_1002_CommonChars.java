package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. 查找常用字符
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/8/6 15:47
 */
public class _1002_CommonChars {

    public static List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[][] ints = new int[26][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++)
                ints[A[i].charAt(j) - 97][i] = ints[A[i].charAt(j) - 97][i] + 1;
        }
        for (int i = 0; i < ints.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < ints[i].length; j++) {
                if (ints[i][j] == 0) {
                    min = 0;
                    break;
                }
                if (min > ints[i][j]) min = ints[i][j];
            }
            for (int j = 0; j < min; j++)
                list.add(String.valueOf((char) ('a' + i)));
        }
        return list;
    }

    public static void main(String[] args) {
        commonChars(new String[]{"cool"});
    }
}
