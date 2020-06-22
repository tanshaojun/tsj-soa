package com.other.io.netty.rpc.provider;

import com.other.io.netty.rpc.publicinterface.TestRpcService;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 16:19
 */
public class TestRpcServiceImpl implements TestRpcService {

    @Override
    public String getString(String str) {
        return "调用成功" + str;
    }

}
