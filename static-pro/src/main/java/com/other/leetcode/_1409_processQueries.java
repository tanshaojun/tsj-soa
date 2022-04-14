package com.other.leetcode;

/**
 * 1409. 查询带键的排列
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/23 16:36
 */
public class _1409_processQueries {

    public int[] processQueries(int[] queries, int m) {

        int[] ms = new int[m];
        for (int i = 0; i < m; i++) {
            ms[i] = i + 1;
        }
        for (int i = 0; i < queries.length; i++) {
            int index = 0;
            int tmp = ms[index];
            while (queries[i] != tmp) {
                index++;
                int m1 = ms[index];
                ms[index] = tmp;
                tmp = m1;
            }
            ms[0] = queries[i];
            queries[i] = index;
        }
        return queries;

    }

}
