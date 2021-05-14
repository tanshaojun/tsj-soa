package com.other.cls.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

/**
 * @Author tansj
 * @Date 2021-05-08 13:12
 * @Version 1.0
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        //读取
        ClassReader classReader = new ClassReader(ASMObj.class.getName());
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        //处理
        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        byte[] data = classWriter.toByteArray();
        //输出
        File f = new File("/Users/tanshaojun/project/tsj-soa/springboot/target/classes/com/other/cls/asm/ASMObj.class");
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(data);
        fout.close();
        System.out.println("now generator cc success!!!!!");
        Class<?> clazz = Class.forName("com.other.cls.asm.ASMObj");
        Method method = clazz.getMethod("say",String.class);
        method.invoke(clazz.newInstance(),"123");
//        Method method2 = clazz.getMethod("say22", String.class);
//        method2.invoke(clazz.newInstance(), "wo shi  say2");
    }
}
