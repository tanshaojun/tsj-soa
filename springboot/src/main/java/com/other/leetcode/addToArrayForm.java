package com.other.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class addToArrayForm {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int c = 10;
        int t = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int y = K % c;
            K = K / c;
            int s = A[i] + y + t;
            if (s < 10) {
                list.add(s);
                t = 0;
            } else {
                t = s / c;
                list.add(s % c);
            }
        }
        while (K != 0) {
            int y = K % c;
            K = K / c;
            int s = y + t;
            if (s < 10) {
                list.add(s);
                t = 0;
            } else {
                t = s / c;
                list.add(s % c);
            }
        }
        if (t != 0) {
            list.add(t);
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{0}, 23));
    }
}
