package com.netty.rpc.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NettyRpcServerApplication {

    @Value("${netty.rpc.server.port}")
    private Integer port;


    public static void main(String[] args) {
        SpringApplication run = new SpringApplication(NettyRpcServerApplication.class);
        run.run(args);
    }

    @Bean
    public NettyServer nettyServer() {
        return new NettyServer(serverHandler(), port);
    }

    @Bean
    public ServerHandler serverHandler() {
        return new ServerHandler();
    }

}
