package com.other.leetcode;

/**
 * 999. 车的可用捕获量
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/3 15:34
 */
public class _999_numRookCaptures {
    public int numRookCaptures(char[][] board) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        int res = 0;
        int tmp = x - 1;
        while (tmp != 0) {
            if (board[tmp][y] == 'B') break;
            if (board[tmp][y] == 'p') {
                res++;
                break;
            }
            tmp--;
        }
        tmp = x + 1;
        while (tmp != board[0].length) {
            if (board[tmp][y] == 'B') break;
            if (board[tmp][y] == 'p') {
                res++;
                break;
            }
            tmp++;
        }
        tmp = y - 1;
        while (tmp != 0) {
            if (board[x][tmp] == 'B') break;
            if (board[x][tmp] == 'p') {
                res++;
                break;
            }
            tmp--;
        }
        tmp = y + 1;
        while (tmp != board.length) {
            if (board[x][tmp] == 'B') break;
            if (board[x][tmp] == 'p') {
                res++;
                break;
            }
            tmp++;
        }
        return res;
    }
}
