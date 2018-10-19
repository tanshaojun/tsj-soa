package com.other.JUC;

public class SynchronizedDemo {
    private static volatile String S = "";

    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static void method() {
    }
}
