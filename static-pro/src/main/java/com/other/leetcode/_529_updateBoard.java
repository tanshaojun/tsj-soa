package com.other.leetcode;

/**
 * 529. 扫雷游戏
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/20 9:59
 */
public class _529_updateBoard {

    public char[][] updateBoard(char[][] board, int[] click) {
        if (null == board || null == click) return board;
        int initx = click[0];
        int inity = click[1];
        int x = board.length;
        int y = board[0].length;
        //1.如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
        if ('M' == board[initx][inity]) {
            board[initx][inity] = 'X';
            return board;
        }
        dfs(board, x, y, initx, inity);
        return board;
    }

    public void dfs(char[][] board, int x, int y, int initx, int inity) {
        int count = 0;
        //左上
        count += initx - 1 >= 0 && inity - 1 >= 0 && board[initx - 1][inity - 1] == 'M' ? 1 : 0;
        //上中
        count += initx - 1 >= 0 && board[initx - 1][inity] == 'M' ? 1 : 0;
        //右上
        count += initx - 1 >= 0 && inity + 1 < y && board[initx - 1][inity + 1] == 'M' ? 1 : 0;
        //右中
        count += inity + 1 < y && board[initx][inity + 1] == 'M' ? 1 : 0;
        //右下
        count += initx + 1 < x && inity + 1 < y && board[initx + 1][inity + 1] == 'M' ? 1 : 0;
        //下中
        count += initx + 1 < x && board[initx + 1][inity] == 'M' ? 1 : 0;
        //左下
        count += initx + 1 < x && inity - 1 >= 0 && board[initx + 1][inity - 1] == 'M' ? 1 : 0;
        //左中
        count += inity - 1 >= 0 && board[initx][inity - 1] == 'M' ? 1 : 0;
        //2.判断click这个点周围地雷的个数,如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
        if (count > 0) {
            board[initx][inity] = (char) ('0' + count);
        } else {
            board[initx][inity] = 'B';
            //3.如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
            if (initx - 1 >= 0 && inity - 1 >= 0 && board[initx - 1][inity - 1] == 'E') {
                dfs(board, x, y, initx - 1, inity - 1);
            }
            if (initx - 1 >= 0 && board[initx - 1][inity] == 'E') {
                dfs(board, x, y, initx - 1, inity);
            }
            if (initx - 1 >= 0 && inity + 1 < y && board[initx - 1][inity + 1] == 'E') {
                dfs(board, x, y, initx - 1, inity + 1);
            }
            if (inity + 1 < y && board[initx][inity + 1] == 'E') {
                dfs(board, x, y, initx, inity + 1);
            }
            if (initx + 1 < x && inity + 1 < y && board[initx + 1][inity + 1] == 'E') {
                dfs(board, x, y, initx + 1, inity + 1);
            }
            if (initx + 1 < x && board[initx + 1][inity] == 'E') {
                dfs(board, x, y, initx + 1, inity);
            }
            if (initx + 1 < x && inity - 1 >= 0 && board[initx + 1][inity - 1] == 'E') {
                dfs(board, x, y, initx + 1, inity - 1);
            }
            if (inity - 1 >= 0 && board[initx][inity - 1] == 'E') {
                dfs(board, x, y, initx, inity - 1);
            }
        }
    }

}
