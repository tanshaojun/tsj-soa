package com.other.JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA
 * name tan shaojun
 * Date: 2019/5/15
 * Time: 9:18 PM
 */
public class MyBlockQueue {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println("生产者启动");
            myResource.myProducer();
        }, "p").start();
        new Thread(() -> {
            System.out.println("消费者启动");
            myResource.myConsumer();
        }, "c").start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myResource.stop();
    }

}

class MyResource {
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<Integer> queue = null;

    public MyResource(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void myProducer() {
        while (flag) {
            try {
                boolean offer = queue.offer(atomicInteger.getAndIncrement(), 2L, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println(Thread.currentThread().getName() + "\t 生产者生产了");
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t 生产者生产失败");
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t   生产者结束。。。。");
    }

    public void myConsumer() {
        while (flag) {
            try {
                Integer poll = queue.poll(2L, TimeUnit.SECONDS);
                if (poll == null) {
                    System.out.println(Thread.currentThread().getName() + "\t 消费者停止消费");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "\t 消费者消费了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.flag = false;
    }
}


