package com.other.io.netty.tcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 10:34
 */
public class NettyTcpServerHandler extends SimpleChannelInboundHandler<Message> {

    private final static Logger logger = LoggerFactory.getLogger(NettyTcpServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        logger.info("客户端发送的长度为：{}", msg.getLen());
        logger.info("客户端发送的消息为：{}", new String(msg.getBytes(), "utf-8"));
        //回复客户端
        Message reply = new Message();
        String m = UUID.randomUUID().toString();
        reply.setLen(m.length());
        reply.setBytes(m.getBytes());
        ctx.writeAndFlush(reply);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
