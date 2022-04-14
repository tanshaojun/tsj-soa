package com.other.leetcode;

/**
 * 905. 按奇偶排序数组
 */
public class _905_sortArrayByParity {
    public static void main(String[] args) {
        System.out.println(sortArrayByParity(new int[]{3, 2, 3}));
    }

    public static int[] sortArrayByParity(int[] A) {
        int index1 = 0;
        int index2 = A.length - 1;
        while (index1 < index2) {
            int i = A[index1];
            int i1 = A[index2];

            int i2 = i % 2;
            int i3 = i1 % 2;

            if (i2 != 0 && i3 == 0) {
                int tmp = A[index1];
                A[index1] = A[index2];
                A[index2] = tmp;
                index1++;
                index2--;
            } else if (i2 == 0 && i3 == 0) {
                index1++;
            } else if (i2 == 0 && i3 != 0) {
                index1++;
                index2--;
            } else if (i2 != 0 && i3 != 0) {
                index2--;
            }
        }
        return A;
    }
}
