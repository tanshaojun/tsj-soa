package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

public class selfDividingNumbers {
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));

    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        boolean t = false;
        for (int i = left; i <= right; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                String c = String.valueOf(s.charAt(j));
                Integer integer = Integer.valueOf(c);
                if (!(integer != 0 && i % integer == 0)) {
                    t = true;
                    break;
                }
            }
            if (!t) list.add(i);
            t = false;
        }
        return list;
    }
}
