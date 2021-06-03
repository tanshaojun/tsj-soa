package com.other.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/15 9:39
 */
public class TestProxy implements InvocationHandler {


    public <T> T newInstance(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        return new User(1, "z   hangsan");
    }

    public static void main(String[] args) {
        TestProxy testProxy = new TestProxy();
        UserMapper userMapper = testProxy.newInstance(UserMapper.class);
        User user = userMapper.get(1000);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(userMapper.toString());

    }
}
