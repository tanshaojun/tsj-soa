package com.other.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1114. 按序打印
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/20 14:16
 */
public class _1114_Foo {

    public _1114_Foo() {
    }

    volatile int count = 1;

    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();


    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (count != 1) {
                c1.await();
            }
            printFirst.run();
            count = 2;
            c2.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (count != 2) {
                c2.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            count = 3;
            c3.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (count != 3) {
                c3.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            count = 1;
            c1.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}
