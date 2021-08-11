package com.netty.rpc;

import lombok.Data;

/**
 * @Author tansj
 * @Date 2021/8/10 下午2:41
 * @Version 1.0
 */
@Data
public class RpcResponse {

    /**
     * 响应ID
     */
    private String requestId;
    /**
     * 错误信息
     */
    private String error;
    /**
     * 返回的结果
     */
    private Object result;


}
