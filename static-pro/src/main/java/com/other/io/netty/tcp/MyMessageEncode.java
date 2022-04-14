package com.other.io.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 11:13
 */
public class MyMessageEncode extends MessageToByteEncoder<Message> {
    private final static Logger logger = LoggerFactory.getLogger(MyMessageEncode.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        logger.info("MyMessageEncode  encode执行了");
        out.writeInt(msg.getLen());
        out.writeBytes(msg.getBytes());
    }

}
