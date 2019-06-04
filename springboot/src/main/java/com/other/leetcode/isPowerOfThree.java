package com.other.leetcode;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/310:37
 */
public class isPowerOfThree {

    public static boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(27));
    }
}
