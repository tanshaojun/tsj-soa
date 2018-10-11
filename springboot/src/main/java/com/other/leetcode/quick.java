package com.other.leetcode;

import java.util.Random;

public class quick {
    public static   void main(String[] args) {
        int[] ints = new int[]{1, 4, 7, 2, 2, 3, 6, 5, 8};
        quickSort(ints, 0, ints.length - 1);
    }

    public static   void quickSort(int[] a, int low, int high) {
        int p;
        while (low < high) {
            int r = new Random().nextInt(high - low) + low;
            swap(a, high, r);
            p = partition(a, low, high);
            quickSort(a, low, p - 1);
            low = p + 1;
        }
    }

    private static   int partition(int[] a, int left, int right) {
        int x = a[right];
        int p = left - 1;
        for (int i = left; i < right; i++) {
            if (a[i] <= x) {
                p++;
                swap(a, p, i);
            }
        }
        swap(a, p + 1, right);
        return p + 1;
    }

    private static   void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}