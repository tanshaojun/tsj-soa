package com.other.leetcode;

public class hasAlternatingBits {
    public static boolean hasAlternatingBits(int n) {
        //求出二进制
//        int[] ints = new int[32];
//        int count = 0;
//        while (n > 0) {
//            int i = n % 2;
//            ints[count++] = i;
//            n = n / 2;
//        }
        //判断相邻是否相等
//        int tmp = ints[0];
//        for (int i = 1; i < count; i++) {
//            if (tmp != ints[i]) {
//                tmp = ints[i];
//            } else {
//                return false;
//            }
//        }
//        return true;
        int temp = n ^ (n >> 1);
        return (temp & (temp + 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        // 101
        // 010
        //0111
        //1000
    }
}
