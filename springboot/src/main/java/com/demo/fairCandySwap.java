package com.demo;

import java.util.ArrayList;
import java.util.List;

public class fairCandySwap {
    public static void main(String[] args) {
        int[] ints = fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4});
        System.out.println(ints);

    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        int[] s = new int[2];
        int sa = 0;
        int sb = 0;
        List<Integer> la = new ArrayList<>();
        List<Integer> lb = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            la.add(A[i]);
            sa += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sb += B[i];
            lb.add(B[i]);
        }
        int i1 = (sa + sb) / 2;
        int c = 0;
        int d = 0;
        if (sa > sb) {
            i1 = i1 - sb;
            while (!la.contains(d) || !lb.contains(c) || (sb - c + d != sa - d + c)) {
                c++;
                d = c + i1;
            }
            s[0] = d;
            s[1] = c;
        } else {
            i1 = i1 - sa;
            while (!la.contains(c) || !lb.contains(d) || (sa - c + d != sb - d + c)) {
                c++;
                d = c + i1;
            }
            s[0] = c;
            s[1] = d;
        }
        return s;

    }
}
