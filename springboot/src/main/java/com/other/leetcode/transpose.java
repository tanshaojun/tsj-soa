package com.other.leetcode;

public class transpose {
    /**
     * 给定一个矩阵 A， 返回 A 的转置矩阵。
     * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     *
     * @param A
     * @return
     */
    public static   int[][] transpose(int[][] A) {
        int[][] ints = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                ints[j][i] = A[i][j];
            }
        }
        return ints;
    }

    public static   void main(String[] args) {
        int[][] ints = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] intss = {
                {1, 4},
                {2, 5},
                {3, 6}
        };
        int[][] transpose = transpose(intss);
        System.out.println(transpose);
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[i].length; j++) {
                System.out.println(transpose[i][j]);
            }
        }
    }
}
