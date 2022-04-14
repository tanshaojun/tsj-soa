package com.other.io.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 10:38
 */
public class NettyTcpClientHandler extends SimpleChannelInboundHandler<Message> {

    private final static Logger logger = LoggerFactory.getLogger(NettyTcpClientHandler.class);

    /**
     * 当通道连接时发送消息
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            String msg = "hello," + i;
            byte[] bytes = msg.getBytes(CharsetUtil.UTF_8);
            Message message = new Message();
            message.setLen(bytes.length);
            message.setBytes(bytes);
            ctx.writeAndFlush(message);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        logger.info("服务端回复的消息的长度为：{}", msg.getLen());
        logger.info("服务端回复的消息为：{}", new String(msg.getBytes(), CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
