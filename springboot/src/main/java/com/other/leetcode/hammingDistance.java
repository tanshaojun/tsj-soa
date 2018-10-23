package com.other.leetcode;

public class hammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(3, 1));
    }

    public static int hammingDistance1(int x, int y) {
        int sum = 0;
        int[] intx = new int[32];
        int count = 0;
        while (x > 0) {
            int i = x % 2;
            intx[count++] = i;
            x = x / 2;
        }

        int[] inty = new int[32];
        int count1 = 0;
        while (y > 0) {
            int i = y % 2;
            inty[count1++] = i;
            y = y / 2;
        }
        for (int i = 0; i < 32; i++) {
            if (intx[i] != inty[i]) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 两数取 异或 在判断1的数量
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int sum = 0;
        int tmp = x ^ y;
        while (tmp != 0) {
            sum++;
            tmp = (tmp - 1) & tmp;
        }
        return sum;
    }
}
