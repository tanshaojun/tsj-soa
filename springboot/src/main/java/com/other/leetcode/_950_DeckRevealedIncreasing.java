package com.other.leetcode;

import java.util.Arrays;

/**
 * 950. 按递增顺序显示卡牌
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/8/9 17:35
 */
public class _950_DeckRevealedIncreasing {
    /**
     * 6  6
     * 5  5 6
     * 4  4 6 5
     * 3  3 5 4 6
     * 2  2 6 3 5 4
     * 1  1 4 2 6 3 5
     *
     * @param deck
     * @return
     */
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        for (int i = deck.length - 2; i >= 0; i--) {
            int tmp = deck[deck.length - 1];
            for (int j = deck.length - 1; j > i; j--) {
                deck[j] = deck[j - 1];
            }
            deck[i + 1] = tmp;
        }
        return deck;
    }

    public static void main(String[] args) {
        deckRevealedIncreasing(new int[]{1, 2,3});
    }
}
