package com.other.io.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/15 11:14
 */
public class NettyClientChannelHandler extends ChannelInboundHandlerAdapter {

    private final static Logger logger = LoggerFactory.getLogger(NettyServerChannelHandler.class);

    /**
     * 当通道就绪时发送消息
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("客户端发送消息中...........");
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,服务端", CharsetUtil.UTF_8));
    }

    /**
     * 读取消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("客户端读取消息中...........");
        ByteBuf byteBuf = (ByteBuf) msg;
        logger.info("客户端接收的消息为:{}", byteBuf.toString(CharsetUtil.UTF_8));
        logger.info("服务器发送的地址为：{}", ctx.channel().remoteAddress());
    }

    /**
     * 异常处理
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("客户端发生异常............");
        ctx.close();
    }

}
