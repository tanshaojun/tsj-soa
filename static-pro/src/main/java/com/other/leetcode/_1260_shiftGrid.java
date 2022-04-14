package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/3 17:59
 */
public class _1260_shiftGrid {
    public static void main(String[] args) {
        List<List<Integer>> lists = shiftGrid(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        }, 3);
        lists.forEach(l -> {
            System.out.println(l);
        });
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 计算该点在变换后所在的位置
                int l = (i * m + j + k) % (n * m);
                temp[l / m][l % m] = grid[i][j];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                sub.add(temp[i][j]);
            }
            result.add(sub);
        }

        return result;
    }

    public static List<List<Integer>> shiftGrid1(int[][] grid, int k) {
        int x = grid.length;
        int y = grid[0].length;
        k = k % (x * y);
        int a = 0;
        int b = 0;
        int tmp;
        for (int i = 0; i < k; i++) {
            tmp = grid[0][0];
            while (true) {
                b += 1;
                if (b >= y) {
                    b = b % y;
                    a++;
                }
                if (a == x) a = a % x;
                int c = grid[a][b];
                grid[a][b] = tmp;
                tmp = c;
                if (a == 0 && b == 0) {
                    break;
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                list.add(grid[i][j]);
            }
            lists.add(list);
        }
        return lists;
    }
}
