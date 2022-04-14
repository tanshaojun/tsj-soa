package com.other.JUC;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {

    private static SynchronousQueue<String> synchronousQueue = new SynchronousQueue();

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                synchronousQueue.put("12");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            String poll = synchronousQueue.poll();
            System.out.println(poll);
        }).start();
    }
}
