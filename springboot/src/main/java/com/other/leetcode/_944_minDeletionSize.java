package com.other.leetcode;

/**
 * 944. 删列造序
 */
public class _944_minDeletionSize {
    public static int minDeletionSize(String[] A) {
        int count = 0;
        for (int i = 0; i < A[0].length(); i++) {
            int tmp = 0;
            boolean flag = false;
            for (int j = 0; j < A.length; j++) {
                char c = A[j].charAt(i);
                if (c >= tmp) {
                    tmp = c;
                } else {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                flag = false;
                count++;
            }
        }
        return count;
    }

    public static int minDeletionSize1(String[] A) {
        int n = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    n++;
                    break;
                }
            }
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"rrjk", "furt", "guzm"}));
    }
}
