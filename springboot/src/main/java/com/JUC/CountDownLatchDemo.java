package com.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CountDownLatchDemo {
    private static   CountDownLatch countDownLatch = new CountDownLatch(5);
    private static   Integer count = 0;

    public static   void main(String[] args) throws ExecutionException, InterruptedException {
        A a = new A();
        FutureTask<Integer> futrueTask = new FutureTask<Integer>(a);
        Thread t = new Thread(futrueTask);
        t.start();
        for (int i = 0; i < countDownLatch.getCount(); i++) {
            new Thread(new B()).start();
        }
        Integer integer = futrueTask.get();
        System.out.println(integer);
    }

    private static   class A implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("正在等待计算结果");
            countDownLatch.await();
            //利用结果计算
            return count * 100;
        }
    }

    private static   class B implements Runnable {
        @Override
        public void run() {
            //计算业务的结果
            count++;
            System.out.println(count);
            countDownLatch.countDown();
        }
    }

}


