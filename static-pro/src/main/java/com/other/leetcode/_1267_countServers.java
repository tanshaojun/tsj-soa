package com.other.leetcode;

/**
 * 1267. 统计参与通信的服务器
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/9 15:32
 */
public class _1267_countServers {

    public int countServers(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        int[] tmp = new int[b];
        int[] as = new int[a];
        int res = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == 1) {
                    tmp[j] += 1;
                    as[i] += 1;
                }
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == 1 && (tmp[j] > 1 || as[i] > 1)) res++;
            }
        }
        return res;
    }
}
