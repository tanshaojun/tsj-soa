package com.other.io.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/17 15:06
 */
public class NettyWebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private final static Logger logger = LoggerFactory.getLogger(NettyWebSocketServerHandler.class);


    /**
     * 读取消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        logger.info("服务端收到消息：{}", msg.text());
        ctx.channel().writeAndFlush(new TextWebSocketFrame(LocalDateTime.now() + "你好，客户端！"));
    }

    /**
     * 连接后触发
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        logger.info("handlerAdded被调用：{}", ctx.channel().id().asLongText());
        logger.info("handlerAdded被调用：{}", ctx.channel().id().asShortText());
    }

    /**
     * 关闭后触发
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        logger.info("handlerRemoved被调用：{}", ctx.channel().id().asLongText());
        logger.info("handlerRemoved被调用：{}", ctx.channel().id().asShortText());
    }

    /**
     * 发生异常
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("有异常发生了message：{}", cause.getMessage());
        ctx.close();
    }



}
