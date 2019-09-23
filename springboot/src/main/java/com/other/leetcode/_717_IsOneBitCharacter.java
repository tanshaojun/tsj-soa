package com.other.leetcode;

/**
 * 717. 1比特与2比特字符
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/9/23 17:11
 */
public class _717_IsOneBitCharacter {
    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}
