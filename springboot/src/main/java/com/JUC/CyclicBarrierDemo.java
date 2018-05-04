package com.JUC;

import javax.sound.midi.Soundbank;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) {
        for (int i = 0; i < cyclicBarrier.getParties(); i++) {
            new Thread(new A()).start();
        }
    }

    private static class A implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "来了.......");
                cyclicBarrier.await();
                //并发请求的业务逻辑
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
