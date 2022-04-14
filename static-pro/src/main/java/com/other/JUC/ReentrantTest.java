package com.other.JUC;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author tansj
 * @Date 2021/6/23 上午11:24
 * @Version 1.0
 */
public class ReentrantTest {

    public final static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        lock.lock();
        lock.unlock();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.add(new Random().nextInt(100));
        }
        System.out.println(0<<1);
    }

}