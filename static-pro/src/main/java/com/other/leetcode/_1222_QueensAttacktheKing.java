package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1222. 可以攻击国王的皇后
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/13 15:37
 */
public class _1222_QueensAttacktheKing {
    public static void main(String[] args) {
        System.out.println(queensAttacktheKing(new int[][]{
                {0, 0},
                {0, 4},
                {1, 1},
                {1, 2}
        }, new int[]{0, 2}));
    }

    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> lists = new ArrayList<>();
        int[][] ints = new int[8][8];
        for (int i = 0; i < queens.length; i++) {
            ints[queens[i][0]][queens[i][1]] = 1;
        }

        int a = king[0];
        int b = king[1];
        int x = -1;
        int y = -1;
        for (int i = 0; i < 8; i++) {
            if (ints[a][i] != 0) {
                if (i < b) {
                    x = a;
                    y = i;
                } else if (i > b) {
                    add(lists, a, i, 1);
                    break;
                }
            }
        }
        if (x != -1) add(lists, x, y, 1);


        x = -1;
        y = -1;
        for (int i = 0; i < 8; i++) {
            if (ints[i][b] != 0) {
                if (i < a) {
                    x = i;
                    y = b;
                } else if (i > a) {
                    add(lists, i, b, 1);
                    break;
                }
            }
        }

        if (x != -1) add(lists, x, y, 1);

        while (a != 0 && b != 0) {
            a--;
            b--;
            if (add(lists, a, b, ints[a][b])) {
                break;
            }
        }
        a = king[0];
        b = king[1];
        while (a != 7 && b != 7) {
            a++;
            b++;
            if (add(lists, a, b, ints[a][b])) {
                break;
            }
        }

        a = king[0];
        b = king[1];
        while (a != 0 && b != 7) {
            a--;
            b++;
            if (add(lists, a, b, ints[a][b])) {
                break;
            }
        }
        a = king[0];
        b = king[1];
        while (a != 7 && b != 0) {
            a++;
            b--;
            if (add(lists, a, b, ints[a][b])) break;
        }

        return lists;
    }

    private static boolean add(List<List<Integer>> lists, int a, int b, int c) {
        if (c == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            lists.add(list);
            return true;
        }
        return false;
    }
}
