package com.other.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 * name tan shaojun
 * Date: 2019/5/9
 * Time: 9:51 PM
 */
public class ConditionDemo {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                printABC("A", new Condition[]{c1, c2}, 1, 2);
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                printABC("B", new Condition[]{c2, c3}, 2, 3);
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                printABC("C", new Condition[]{c3, c1}, 3, 1);
            }
        }, "CC").start();
    }

    private static volatile int count = 1;
    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    public static void printABC(String s, Condition[] c, Integer ccc, Integer cccc) {
        lock.lock();
        try {
            lock.lock();
            try {
                while (count != ccc) {
                    c[0].await();
                }
                System.out.println(Thread.currentThread().getName() + "\t " + s);
                count = cccc;
                c[1].signal();
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                lock.unlock();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printA() {
        lock.lock();
        try {
            while (count != 1) {
                c1.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t A");
            count = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (count != 2) {
                c2.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t B");
            count = 3;
            c3.signal();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (count != 3) {
                c3.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t C");
            count = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }
}
