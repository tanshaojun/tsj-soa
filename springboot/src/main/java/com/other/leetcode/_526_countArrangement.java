package com.other.leetcode;

/**
 * 526. 优美的排列
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/15 10:31
 */
public class _526_countArrangement {

    int count = 0;

    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        process(N, 1, visited);
        return count;
    }

    public void process(int N, int pos, boolean[] visited) {
        if (pos > N) count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                process(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}
