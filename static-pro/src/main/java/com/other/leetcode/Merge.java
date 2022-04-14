package com.other.leetcode;

public class Merge {
    public static   void main(String[] args) {
        int[] ints = new int[]{2, 5, 8, 3, 4, 7, 6, 12, 8, 0, 99, 55, 44, 66, 22, 33};
        mergeSort(ints);
        System.out.println(ints);
    }

    public static   void mergeSort(int[] ints) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[ints.length];
        sort(ints, 0, ints.length - 1, temp);
    }

    private static   void sort(int[] ints, int l, int r, int[] temp) {
        if (l < r) {
            int mid = l + ((r - l) >> 1);
            //分
            sort(ints, l, mid, temp);
            //分
            sort(ints, mid + 1, r, temp);
            //合并操作
            merge(ints, l, mid, r, temp);
        }
    }

    /**
     * //将两个有序数组合并为一个数组
     *
     * @param ints 排序数组
     * @param l
     * @param mid
     * @param r
     * @param temp 临时数组
     */
    private static   void merge(int[] ints, int l, int mid, int r, int[] temp) {
        //第一个数组的开头
        int i = l;
        //第二个数组的开头
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= r) {
            if (ints[i] < ints[j]) temp[count++] = ints[i++];
            else temp[count++] = ints[j++];
        }
        while (i <= mid) temp[count++] = ints[i++];
        while (j <= r) temp[count++] = ints[j++];
        //将临时数组的值追加到原数组
        for (i = 0; i < count; i++) ints[l + i] = temp[i];
    }
}
