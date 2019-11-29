package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * 969. 煎饼排序
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/29 13:45
 */
public class _969_pancakeSort {
    public static void main(String[] args) {
        System.out.println(pancakeSort(new int[]{3, 2, 4, 1}));
    }

    public static List<Integer> pancakeSort(int[] A) {
        int len = A.length;
        List<Integer> list = new ArrayList<>();
        r(list, len, A);
        return list;
    }

    private static void r(List<Integer> list, int len, int[] A) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < len; i++) {
            if (max < A[i]) {
                max = A[i];
                index = i;
            }
        }
        if (index == len - 1) {
            if (len == 1) return;
            r(list, --len, A);
        } else {

            int left = 0;
            int right = index;
            if (index > 0) {
                list.add(index + 1);
                while (left < right) {
                    swap(A, left++, right--);
                }
            }
            left = 0;
            right = len - 1;
            while (left < right) {
                swap(A, left++, right--);
            }
            list.add(len);
            len--;
            if (len == 2) {
                if (A[1] > A[0]) {
                    return;
                } else {
                    list.add(2);
                    swap(A, 0, 1);
                }
                return;
            }
            r(list, len, A);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
