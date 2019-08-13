package com.other.leetcode;

/**
 * 914. 卡牌分组
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/8/9 16:56
 */
public class _914_HasGroupsSizeX {

    public static boolean hasGroupsSizeX(int[] deck) {
        int[] ints = new int[10001];
        for (int i = 0; i < deck.length; i++) {
            ints[deck[i]] = ints[deck[i]] + 1;
        }
        for (int i = 2; i <= 10000; i++) {
            boolean tmp = true;
            for (int j = 1; j < ints.length; j++) {
                if (ints[j] == 0) {
                    continue;
                }
                if (ints[j] == 1) {
                    return false;
                }
                if (ints[j] % i != 0) {
                    tmp = false;
                    break;
                }
            }
            if (tmp) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1}));
    }

}
