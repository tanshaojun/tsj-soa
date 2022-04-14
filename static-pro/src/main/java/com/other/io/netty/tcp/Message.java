package com.other.io.netty.tcp;

import lombok.Data;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 11:11
 */
@Data
public class Message {
    private int len;
    private byte[] bytes;
}
