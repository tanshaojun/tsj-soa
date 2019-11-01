package com.other.leetcode;

/**
 * 1122. 数组的相对排序
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/10/31 10:08
 */
public class _1122_RelativeSortArray {
    public static void main(String[] args) {
        for (int i : relativeSortArray(new int[]{}, new int[]{})) {
            System.out.println(i);
        }
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int l = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    swap(arr1, j, l);
                    l++;
                }
            }
        }
        for (int i = l + 1; i < arr1.length; i++) {
            for (int j = i - 1; j >= l && arr1[j] > arr1[j + 1]; j--)
                swap(arr1, j, j + 1);
        }
        return arr1;
    }

    private static void swap(int[] arr1, int j, int l) {
        int tmp = arr1[j];
        arr1[j] = arr1[l];
        arr1[l] = tmp;
    }

}
