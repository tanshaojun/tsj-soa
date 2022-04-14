package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 */
public class _119_GetRow {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> l = new ArrayList<>(16);
        rowIndex++;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        l.add(list);
        for (int i = 1; i < rowIndex; i++) {
            List<Integer> tmp = l.get(i - 1);
            List<Integer> integerList = new ArrayList<>();
            integerList.add(1);
            for (int j = 1; j < tmp.size(); j++) {
                integerList.add(tmp.get(j) + tmp.get(j - 1));
            }
            integerList.add(1);
            l.add(integerList);
        }
        return l.get(rowIndex - 1);
    }
}
