package com.other.leetcode;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/39:40
 */
public class isUgly {

    public static boolean isUgly(int num) {
        if (num > 0) {
            while (num > 1) {
                if (num % 5 == 0) {
                    num /= 5;
                } else {
                    if (num % 3 == 0) {
                        num /= 3;
                    } else {
                        if (num % 2 == 0) {
                            num /= 2;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
