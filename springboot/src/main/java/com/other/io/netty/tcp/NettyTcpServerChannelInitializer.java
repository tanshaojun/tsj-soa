package com.other.io.netty.tcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 10:32
 */
public class NettyTcpServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //解码器
        pipeline.addLast(new MyMessageDecode());
        //编码器
        pipeline.addLast(new MyMessageEncode());
        pipeline.addLast(new NettyTcpServerHandler());
    }
}
