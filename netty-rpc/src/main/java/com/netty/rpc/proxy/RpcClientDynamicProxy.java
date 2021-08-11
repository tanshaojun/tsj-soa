package com.netty.rpc.proxy;


import com.netty.rpc.RpcRequest;
import com.netty.rpc.RpcResponse;
import com.netty.rpc.client.NettyClient;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

/**
 * @Author tansj
 * @Date 2021/8/10 下午2:48
 * @Version 1.0
 */
@Slf4j
public class RpcClientDynamicProxy<T> implements InvocationHandler {
    private Class<T> interfaceClazz;

    private String host;

    private Integer port;

    public RpcClientDynamicProxy(Class<T> interfaceClazz, String host, Integer port) {
        this.interfaceClazz = interfaceClazz;
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest request = new RpcRequest();
        String requestId = UUID.randomUUID().toString();

        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();

        Class<?>[] parameterTypes = method.getParameterTypes();

        request.setRequestId(requestId);
        request.setClassName(className);
        request.setMethodName(methodName);
        request.setParameterTypes(parameterTypes);
        request.setParameters(args);
//        log.info("请求内容: {}", request);

        //开启Netty 客户端，直连
        //这里直接指定了server的host和port，正常的RPC框架会从注册中心获取
        NettyClient nettyClient = new NettyClient(host, port);
//        log.info("开始连接服务端：{}", new Date());
        nettyClient.connect();
        RpcResponse send = nettyClient.send(request);
//        log.info("请求调用返回结果：{}", send.getResult());
        return send.getResult();
    }

    @SuppressWarnings("unchecked")
    public T getProxy() {
        return (T) Proxy.newProxyInstance(
                interfaceClazz.getClassLoader(),
                new Class<?>[]{interfaceClazz},
                this

        );
    }
}