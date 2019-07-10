package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 */
public class _118_Generate {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<>(16);
        if (numRows == 0) {
            return l;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        l.add(list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = l.get(i - 1);
            List<Integer> integerList = new ArrayList<>();
            integerList.add(1);
            for (int j = 1; j < tmp.size(); j++) {
                integerList.add(tmp.get(j) + tmp.get(j - 1));
            }
            integerList.add(1);
            l.add(integerList);
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
