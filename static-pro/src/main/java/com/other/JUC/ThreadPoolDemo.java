package com.other.JUC;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA
 * name tan shaojun
 * Date: 2019/5/16
 * Time: 9:09 PM
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                1,
                1,
                1L,
                TimeUnit.SECONDS,
                blockingQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 运行了");
            });
        }
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
