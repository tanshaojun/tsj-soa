package com.other.leetcode;

/**
 * 1337. 方阵中战斗力最弱的 K 行
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/30 15:28
 */
public class _1337_kWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        int x = mat.length;
        int y = mat[0].length;
        int[] tmp = new int[x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (mat[i][j] == 1) tmp[i] += 1;
                else break;
            }
        }
        int[] res = new int[k];
        int index = 0;
        int count = 0;
        while (k > 0) {
            for (int i = 0; i < tmp.length; i++) {
                if (count == tmp[i]) {
                    res[index++] = i;
                    k--;
                    if (k == 0) {
                        return res;
                    }
                }
            }
            count++;

        }
        return res;
    }
}
