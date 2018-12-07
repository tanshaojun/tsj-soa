package com.other.JUC;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeDemo {
    public static void main(String[] args) {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);
            System.out.println(unsafe);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
