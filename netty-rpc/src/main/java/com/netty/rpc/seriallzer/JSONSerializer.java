package com.netty.rpc.seriallzer;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

/**
 * @Author tansj
 * @Date 2021/8/10 下午2:43
 * @Version 1.0
 */
public class JSONSerializer implements Serializer {
    public byte[] serialize(Object object) throws IOException {
        return JSON.toJSONBytes(object);
    }

    public <T> T deserialize(Class<T> clazz, byte[] bytes) throws IOException {
        return JSON.parseObject(bytes, clazz);
    }
}
