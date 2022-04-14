package com.other.jvm;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * name tan shaojun
 * Date: 2019/5/29
 * Time: 10:17 PM
 */
public class GCDemo {

    static int b = 1024;

    public static void main(String[] args) {
        List<ByteBuffer> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(b);
                list.add(byteBuffer);
                i++;
            }
        } finally {
            System.out.println(i);
        }
    }
}
