package com.other.io.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/16 17:55
 */
public class NettyGroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    private final static Logger logger = LoggerFactory.getLogger(NettyGroupChatServerHandler.class);

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 表示建立连接
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("客户端" + channel.remoteAddress() + "加入聊天");
        channelGroup.add(channel);
    }

    /**
     * 表示断开连接
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("客户端" + channel.remoteAddress() + "离开聊天");
    }

    /**
     * 表示channel处于活跃状态
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        logger.error("{}上线了.......", channel.remoteAddress());
    }

    /**
     * 表示channel处于非活跃状态
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.error("{}下线了.......", ctx.channel().remoteAddress());
    }

    /**
     * 读取消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        logger.info("客户端发送的消息为：{}", msg);
        logger.info("服务端转发消息中.......");
        //转发消息中
        for (Channel channel : channelGroup) {
            if (channel != ctx.channel()) {
                channelGroup.writeAndFlush(msg);
            }
        }
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
        cause.printStackTrace();
        ctx.close();
    }

}
