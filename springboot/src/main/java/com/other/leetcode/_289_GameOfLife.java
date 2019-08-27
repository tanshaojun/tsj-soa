package com.other.leetcode;

/**
 * 289. 生命游戏
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/8/27 16:22
 */
public class _289_GameOfLife {
    public static void gameOfLife(int[][] board) {
        int[][] tmp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            int length = board[i].length;
            for (int j = 0; j < length; j++) {
                int a = i - 1 >= 0 && j - 1 >= 0 ? board[i - 1][j - 1] : 0;
                int b = i - 1 >= 0 ? board[i - 1][j] : 0;
                int c = i - 1 >= 0 && j + 1 < length ? board[i - 1][j + 1] : 0;
                int d = j - 1 >= 0 ? board[i][j - 1] : 0;
                int e = j + 1 < length ? board[i][j + 1] : 0;
                int f = i + 1 < board.length && j - 1 >= 0 ? board[i + 1][j - 1] : 0;
                int g = i + 1 < board.length ? board[i + 1][j] : 0;
                int h = i + 1 < board.length && j + 1 < length ? board[i + 1][j + 1] : 0;
                int sum = a + b + c + d + e + f + g + h;
                boolean b1 = board[i][j] == 0 && sum == 3;
                boolean b2 = board[i][j] == 1 && (sum == 3 || sum == 2);
                if (b1 || b2) {
                    tmp[i][j] = 1;
                } else {
                    tmp[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = tmp[i][j];
            }
        }
    }

    public static void main(String[] args) {
        gameOfLife(new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        });
    }
}
