package com.other.io.netty.rpc.provider;

import com.other.io.netty.rpc.netty.NettyRpcServer;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 16:05
 */
public class ServerBootstrap {
    public static void main(String[] args) {
        NettyRpcServer.start("127.0.0.1", 8989);
    }
}
