package com.netty.rpc.client;

import com.netty.rpc.proxy.RpcClientDynamicProxy;
import com.netty.rpc.server.test.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyRpcClientApplication {


    private final static Logger log = LoggerFactory.getLogger(NettyRpcClientApplication.class);

    public static void main(String[] args) {
        SpringApplication run = new SpringApplication(NettyRpcClientApplication.class);
        run.run(args);
        HelloService helloService = new RpcClientDynamicProxy<>(HelloService.class, "127.0.0.1", 1003).getProxy();
        String result = helloService.hello("zs");
        log.info("响应结果“: {}", result);
    }
}
