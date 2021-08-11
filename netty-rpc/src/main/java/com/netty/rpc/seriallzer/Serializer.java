package com.netty.rpc.seriallzer;

import java.io.IOException;

/**
 * @Author tansj
 * @Date 2021/8/10 下午2:42
 * @Version 1.0
 */
public interface Serializer {
    /**
     * java对象转换为二进制
     *
     * @param object
     * @return
     */
    byte[] serialize(Object object) throws IOException;

    /**
     * 二进制转换成java对象
     *
     * @param clazz
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes) throws IOException;
}
