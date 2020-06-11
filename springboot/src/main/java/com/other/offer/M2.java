package com.other.offer;

import lombok.Synchronized;

/**
 * 面试题2:实现Singleton模式
 */
public class M2 {

    /**
     * 饿汉式（线程不安全）
     */
    public static class Singleton1 {

        private static Singleton1 instance = null;

        public static Singleton1 getInstance() {
            if (null == instance) return new Singleton1();
            return instance;
        }

    }

    /**
     * 饿汉式（线程安全）
     */
    public static class Singleton2 {

        private static Singleton2 instance = null;

        public static synchronized Singleton2 getInstance() {
            if (null == instance) return new Singleton2();
            return instance;
        }

    }

    /**
     * 饿汉式（DCL非线程安全）
     */
    public static class Singleton3 {

        private static Singleton3 instance = null;

        public static Singleton3 getInstance() {
            if (null == instance) {
                synchronized (Singleton3.class) {
                    if (null == instance)
                        instance = new Singleton3();
                }
            }
            return instance;
        }

    }

    /**
     * 饿汉式（DCL线程安全）
     */
    public static class Singleton4 {

        private static volatile Singleton4 instance = null;

        public static Singleton4 getInstance() {
            if (null == instance) {
                synchronized (Singleton4.class) {
                    if (null == instance)
                        instance = new Singleton4();
                }
            }
            return instance;
        }

    }

    /**
     * 懒汉式（线程安全）
     */
    public static class Singleton5 {

        private static Singleton5 instance = new Singleton5();

        public static Singleton5 getInstance() {
            return instance;

        }

    }

    /**
     * 枚举方式（线程安全）
     */
    public enum Singleton6 {
        INSTANCE;
    }


    /**
     * 静态内部类（线程安全）
     */
    public static class Singleton7 {

        private final static class SingletonHolder {
            private static final Singleton7 INSTANCE = new Singleton7();
        }

        public static Singleton7 getInstance() {
            return SingletonHolder.INSTANCE;
        }

    }


}
