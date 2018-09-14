package com.proxy.test;

import com.proxy.i.UserService;
import com.proxy.i.impl.UserServiceImpl;
import com.proxy.t.MyInvocatioHandler;

/**
 * Created with IntelliJ IDEA
 * name tan shaojun
 * Date: 2018/9/9
 * Time: 下午2:56
 */
public class TestProxy {
    public static void main(String[] args) {
        UserService us = new UserServiceImpl();
        MyInvocatioHandler mi = new MyInvocatioHandler(us);
        UserService proxy = (UserService) mi.getProxy();
        proxy.test();
    }
}
