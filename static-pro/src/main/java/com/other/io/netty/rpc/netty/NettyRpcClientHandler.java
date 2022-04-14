package com.other.io.netty.rpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 16:26
 */
public class NettyRpcClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext context;
    /**
     * 服务端返回的数据
     */
    private String result;
    /**
     * 客户端发送给服务端的数据
     */
    private String para;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.context = ctx;
    }

    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        this.result = msg.toString();
        notify();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public synchronized Object call() throws Exception {
        context.writeAndFlush(para);
        wait();
        return result;
    }

    public void setPara(String para) {
        this.para = para;
    }
}
