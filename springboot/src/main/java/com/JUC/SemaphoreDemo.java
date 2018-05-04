package com.JUC;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    private static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new A()).start();
        }
    }

    private static class A implements Runnable {
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "进入............");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "释放前............");
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + "释放后............");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
