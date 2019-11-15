package com.other.leetcode;

/**
 * 441. 排列硬币
 */
public class _441_arrangeCoins {
    public static   void main(String[] args) {
        System.out.println(arrangeCoins(3));
    }

    public static   int arrangeCoins(int n) {
        int index = 1;
        int count = n;
        while (count >= index) {
            count = count - index;
            index++;
        }
        return index-1;
    }
}
