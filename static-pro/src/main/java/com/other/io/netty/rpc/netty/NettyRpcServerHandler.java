package com.other.io.netty.rpc.netty;

import com.other.io.netty.rpc.provider.TestRpcServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 16:13
 */
public class NettyRpcServerHandler extends ChannelInboundHandlerAdapter {

    private final static Logger logger = LoggerFactory.getLogger(NettyRpcServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("获取客户端发送的消息。。。。。。。。");
        ctx.writeAndFlush(new TestRpcServiceImpl().getString(msg.toString()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
