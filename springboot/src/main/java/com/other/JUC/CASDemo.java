package com.other.JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/10/16 15:37
 */
public class CASDemo {

    private static AtomicInteger atomicInteger = new AtomicInteger(100);
    /**
     * 带版本号的cas，防止ABA问题
     */
    private static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100, 1);

    public static void main(String[] args) {

        new Thread(() -> {
            atomicInteger.compareAndSet(100, 101);
            atomicInteger.compareAndSet(101, 100);
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("AtomicInteger:" + atomicInteger.compareAndSet(100, 120));
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.weakCompareAndSet(100, 101, atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1);
            atomicStampedReference.weakCompareAndSet(101, 100, atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1);
        }).start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("AtomicStampedReference:" + atomicStampedReference.compareAndSet(100, 120, stamp,
                    stamp + 1));

        }).start();
    }
}
