package com.proxy.t;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA
 * name tan shaojun
 * Date: 2018/9/9
 * Time: 下午2:51
 */
public class MyInvocatioHandler implements InvocationHandler {

    public Object o;

    public MyInvocatioHandler(Object o) {
        this.o = o;
    }

    /**
     * 调用目标方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object obj = method.invoke(o,args);
        System.out.println("end");
        return obj;
    }

    /**
     * 获取代理对象
     *
     * @return
     */
    public Object getProxy() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] interfaces = o.getClass().getInterfaces();
        return Proxy.newProxyInstance(contextClassLoader, interfaces, this);
    }

}
