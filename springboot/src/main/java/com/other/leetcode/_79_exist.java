package com.other.leetcode;

/**
 * 79. 单词搜索
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/26 15:21
 */
public class _79_exist {

    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        boolean[][] visited = new boolean[x][y];
        int index = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == word.charAt(index)) {
                    if (dfs(board, x, y, i, j, index, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, int i, int j, int index, String word,
                        boolean[][] visited) {
        if (i < 0 || i >= x || j < 0 || j >= y || visited[i][j] || index >= word.length() || word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        boolean flag;
        index++;
        visited[i][j] = true;
        flag =  dfs(board, x, y, i + 1, j, index, word, visited) ||
                dfs(board, x, y, i - 1, j, index, word, visited) ||
                dfs(board, x, y, i, j + 1, index, word, visited) ||
                dfs(board, x, y, i, j - 1, index, word, visited);
        visited[i][j] = false;
        return flag;
    }


}
