package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

public class minimumTotal {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] tmp = new int[triangle.size()];
        List<Integer> list1 = triangle.get(tmp.length - 1);
        for (int j = 0; j < list1.size(); j++) tmp[j] = list1.get(j);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++)
                tmp[j] = list.get(j) + (tmp[j] > tmp[j + 1] ? tmp[j + 1] : tmp[j]);
        }
        return tmp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        lists.add(list);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        lists.add(list1);

        System.out.println(minimumTotal(lists));
    }
}
