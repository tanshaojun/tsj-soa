package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

public class calPoints {
    public static int calPoints(String[] ops) {
        int sum = 0;
        int count = 0;
        int a = 0;
        int b = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if ("+".equals(op)) {
                if (list.size() - 1 - count >= 0) {
                    a = list.get(list.size() - 1 - count);
                }
                if (list.size() - 1 - count >= 0) {
                    b = list.get(list.size() - 2 - count);
                }
                sum += (a + b);
            } else if ("D".equals(op)) {
                if (list.size() - 1 - count >= 0) {
                    a = list.get(list.size() - 1 - count);
                }
                sum += a * 2;
                list.add(a * 2);
            } else if ("C".equals(op)) {
                if (list.size() - 1 - count >= 0) {
                    a = list.get(list.size() - 1 - count);
                }
                sum -= a;
                count++;
            } else {
                Integer integer = Integer.valueOf(op);
                sum += integer;
                list.add(integer);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));

    }
}
