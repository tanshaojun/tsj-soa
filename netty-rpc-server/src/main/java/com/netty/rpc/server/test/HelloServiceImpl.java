package com.netty.rpc.server.test;

import org.springframework.stereotype.Service;

/**
 * @Author tansj
 * @Date 2021/8/10 下午3:02
 * @Version 1.0
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello, " + name;
    }

}
