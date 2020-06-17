package com.other.io.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/15 10:52
 */
public class NettyServerChannelHandler extends ChannelInboundHandlerAdapter {

    private final static Logger logger = LoggerFactory.getLogger(NettyServerChannelHandler.class);

    /**
     * 读取客户端发送的数据
     *
     * @param ctx 上下文对象
     * @param msg 消息
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //放入taskQueue
//        ctx.channel().eventLoop().execute(() -> {
//
//        });

        //提交到scheduleTaskQueue
//        ctx.channel().eventLoop().schedule(() -> {
//
//        }, 5, TimeUnit.SECONDS);

        logger.info("服务端读取消息中............");
        ByteBuf byteBuf = (ByteBuf) msg;
        logger.info("客户端发送的数据为：{}", byteBuf.toString(CharsetUtil.UTF_8));
        logger.info("客户端地址为：{}", ctx.channel().remoteAddress());
    }

    /**
     * 回复客户端
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("服务端回复消息中.........");
        //将数据写入缓存并刷新
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端", CharsetUtil.UTF_8));
    }

    /**
     * 处理异常
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("服务端发生异常............");
        //关闭通道
        ctx.close();
    }

}
