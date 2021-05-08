package com.other.cls.Instrument;

import java.lang.instrument.Instrumentation;

/**
 * @Author tansj
 * @Date 2021-05-08 13:33
 * @Version 1.0
 */
public class TestAgent {
    public static void agentmain(String args, Instrumentation inst) {
        //指定我们自己定义的Transformer，在其中利用Javassist做字节码替换
        inst.addTransformer(new TestTransformer(), true);
        try {
            //重定义类并载入新的字节码
            inst.retransformClasses(InstrumentTest.class);
            System.out.println("Agent Load Done.");
        } catch (Exception e) {
            System.out.println("agent load failed!");
        }
    }
}
