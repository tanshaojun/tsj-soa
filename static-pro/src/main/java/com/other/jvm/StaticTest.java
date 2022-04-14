package com.other.jvm;

public class StaticTest {


    public static void main(String[] args) {
        staticFunction();
    }
    static StaticTest staticTest = new StaticTest();

    static {
        System.out.println("1");
    }


    static int b = 2;

    {
        System.out.println("2");
    }

    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    private static void staticFunction() {
        System.out.println(4);
    }

    int a = 1;


}
