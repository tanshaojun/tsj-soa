package com.other.io.netty.rpc.customer;

import com.other.io.netty.rpc.netty.NettyRpcClient;
import com.other.io.netty.rpc.publicinterface.TestRpcService;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 16:43
 */
public class ClientBootstrap {

    public static void main(String[] args) {
        NettyRpcClient client = new NettyRpcClient();
        TestRpcService testRpcService = (TestRpcService) client.getBean(TestRpcService.class);
        System.out.println(testRpcService.getString("你好！"));
    }

}
