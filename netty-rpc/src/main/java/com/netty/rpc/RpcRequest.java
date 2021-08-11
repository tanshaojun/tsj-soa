package com.netty.rpc;

import lombok.Data;

/**
 * @Author tansj
 * @Date 2021/8/10 下午2:41
 * @Version 1.0
 */
@Data
public class RpcRequest {

    /**
     * 请求对象的ID，客户端用来验证服务器请求和响应是否匹配
     */
    private String requestId;
    /**
     * 类名
     */
    private String className;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 参数类型
     */
    private Class<?>[] parameterTypes;
    /**
     * 入参
     */
    private Object[] parameters;

}
