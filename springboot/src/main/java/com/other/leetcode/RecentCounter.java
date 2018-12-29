package com.other.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    Queue<Integer> q = null;

    public RecentCounter() {
        q = new LinkedList<Integer>();
    }

    public int ping(int t) {
        q.offer(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
}
