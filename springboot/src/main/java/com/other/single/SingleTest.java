package com.other.single;

import java.io.Serializable;

/**
 * 静态类部类的方式
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/9/26 16:31
 */
public class SingleTest implements Serializable {

    private static final long serialVersionUID = 1L;

    private SingleTest() {
    }

    private static class SingletonHolder {
        private static SingleTest singleTest = new SingleTest();
    }

    public static SingleTest getInstance() {
        return SingletonHolder.singleTest;
    }

}

enum SingleTest1 implements Serializable {
    INSTANCE;

    private static final long serialVersionUID = 1L;

    private String obj;

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getObj() {
        return obj;
    }

}
