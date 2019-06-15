package com.other.jvm;

/**
 * Created with IntelliJ IDEA
 * name tan shaojun
 * Date: 2019/5/29
 * Time: 10:17 PM
 */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println(111);
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
