package com.JUC;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static   void main(String[] args) {
        List<String> buffera = new ArrayList<>();
        List<String> bufferb = new ArrayList<>();
        Exchanger<List<String>> exchanger = new Exchanger<>();
        new Thread(new A(buffera, exchanger)).start();
        new Thread(new B(bufferb, exchanger)).start();
    }

    private static   class A implements Runnable {
        private List<String> buffer;
        private Exchanger<List<String>> exchanger;
        private Integer i = 0;

        public A(List<String> buffer, Exchanger<List<String>> exchanger) {
            this.buffer = buffer;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    buffer = exchanger.exchange(buffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者已消费..............第" + (i++) + "次消费");
                buffer.remove(0);
            }
        }
    }

    private static   class B implements Runnable {
        private List<String> buffer;
        private Exchanger<List<String>> exchanger;
        private Integer i = 0;

        public B(List<String> buffer, Exchanger<List<String>> exchanger) {
            this.buffer = buffer;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            while (true) {
                buffer.add("123");
                System.out.println("生产者以装满..............第" + (i++) + "次装满");
                try {
                    buffer = exchanger.exchange(buffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
