package com.other.io.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 11:13
 */
public class MyMessageDecode extends ReplayingDecoder<Void> {

    private final static Logger logger = LoggerFactory.getLogger(MyMessageDecode.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        logger.info("MyMessageDecode decode 执行了......");
        int len = in.readInt();
        byte[] bytes = new byte[len];
        in.readBytes(bytes);
        Message message = new Message();
        message.setLen(len);
        message.setBytes(bytes);
        out.add(message);
    }

}
