package com.other.cls.Instrument;

import java.lang.management.ManagementFactory;

/**
 * @Author tansj
 * @Date 2021-05-08 14:27
 * @Version 1.0
 */
public class InstrumentTest {


    public static void test() {
        System.out.println("1111111");
    }


    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        //打印当前Pid
        System.out.println("pid:" + s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            test();
        }
    }


}
