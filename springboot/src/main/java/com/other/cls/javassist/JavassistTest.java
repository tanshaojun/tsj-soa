package com.other.cls.javassist;

import javassist.*;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author tansj
 * @Date 2021-05-08 13:25
 * @Version 1.0
 */
public class JavassistTest {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException, NoSuchMethodException, InvocationTargetException {
//        ClassPool cp = ClassPool.getDefault();
//        CtClass cc = cp.get("com.other.cls.javassist.JavassistObj");
//        CtMethod m = cc.getDeclaredMethod("say");
//        m.insertBefore("{ System.out.println(\"start\"); }");
//        m.insertAfter("{ System.out.println(\"end\"); }");
//        Class c = cc.toClass();
//        cc.writeFile("/Users/tanshaojun/project/tsj-soa/springboot/target/classes/com/other/cls/javassist");
//        JavassistObj h = (JavassistObj) c.newInstance();
//        h.say("123");
        Class clazz = generateClass("say1");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("say1", JavassistObj.class);
        JavassistObj api = new JavassistObj();
        method.invoke(obj, api);
    }

    public static Class generateClass(String methodName)
            throws CannotCompileException, NotFoundException {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.other.cls.javassist.JavassistObj");

        String desc = Descriptor.ofMethod(CtClass.voidType, new CtClass[]{});
        ConstPool c = cc.getClassFile2().getConstPool();
        MethodInfo methodInfo = new MethodInfo(c, methodName, desc);
        cc.setModifiers(Modifier.PUBLIC);
        CtMethod m = CtMethod.make(methodInfo, cc);
        cc.addMethod(m);

        return cc.toClass();
    }
}
