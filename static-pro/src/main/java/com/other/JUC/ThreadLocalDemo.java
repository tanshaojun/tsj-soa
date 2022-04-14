package com.other.JUC;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/10/17 15:56
 */
public class ThreadLocalDemo {
    private static ThreadLocal<Integer> seqCount = new ThreadLocal<Integer>() {
        // 实现initialValue()
        public Integer initialValue() {
            return 0;
        }
    };

    public int nextSeq() {
        seqCount.set(seqCount.get() + 1);

        return seqCount.get();
    }

    public static void main(String[] args) {
        ThreadLocalDemo seqCount = new ThreadLocalDemo();
        for (int i = 0; i < 10; i++) {
            new SeqThread(seqCount).start();
        }
    }

    private static class SeqThread extends Thread {
        private ThreadLocalDemo seqCount;

        SeqThread(ThreadLocalDemo seqCount) {
            this.seqCount = seqCount;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " seqCount :" + seqCount.nextSeq());
            }
        }
    }
}
