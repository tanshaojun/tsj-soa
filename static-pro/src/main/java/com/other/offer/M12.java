package com.other.offer;

public class M12 {

    /**
     * 矩阵中的路径
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有的路径，路径可以从矩阵中的任意一格移动，每一步可以在矩阵中向左，右，上，下移动.
     * 如果一条路径经过了矩阵的某一个，那么该路径不能再次进入。
     *
     * @param arr
     * @param s
     * @return
     */
    public boolean hasPath(char[][] arr, String s) {
        if (null == arr || s == null || 0 == arr.length || 0 == s.length()) return false;
        int x = arr.length;
        int y = arr[0].length;
        int index = 0;
        boolean[][] visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (arr[i][j] == s.charAt(index)) {
                    if (dfs(arr, i, j, index, s, x, y, visited)) return true;
                }
            }

        }
        return false;
    }

    private boolean dfs(char[][] arr, int i, int j, int index, String s, int x, int y, boolean[][] visited) {
        if (i < 0 || i >= x || j < 0 || j >= y || index >= s.length()) return false;
        boolean flags = false;
        if ((!visited[i][j]) && arr[i][j] == s.charAt(index)) {
            visited[i][j] = !flags;
            if (index == s.length() - 1) return !flags;
            index++;
            flags = dfs(arr, i + 1, j, index, s, x, y, visited) ||
                    dfs(arr, i - 1, j, index, s, x, y, visited) ||
                    dfs(arr, i, j - 1, index, s, x, y, visited) ||
                    dfs(arr, i, j + 1, index, s, x, y, visited);
        }
        visited[i][j] = false;
        return flags;
    }
}
