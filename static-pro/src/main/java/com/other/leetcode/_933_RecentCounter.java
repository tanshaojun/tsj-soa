package com.other.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 933. 最近的请求次数
 */
public class _933_RecentCounter {

    Queue<Integer> q = null;

    public _933_RecentCounter() {
        q = new LinkedList<Integer>();
    }

    public int ping(int t) {
        q.offer(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
}
