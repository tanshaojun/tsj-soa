package com.other.cls.javassist;

import javassist.*;

import java.io.IOException;

/**
 * @Author tansj
 * @Date 2021-05-08 13:25
 * @Version 1.0
 */
public class JavassistTest {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.other.cls.javassist.JavassistObj");
        CtMethod m = cc.getDeclaredMethod("say");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("/Users/tanshaojun/project/tsj-soa/springboot/target/classes/com/other/cls/javassist");
        JavassistObj h = (JavassistObj) c.newInstance();
        h.say("123");
    }
}
