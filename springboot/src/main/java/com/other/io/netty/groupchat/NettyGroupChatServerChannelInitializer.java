package com.other.io.netty.groupchat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/16 17:54
 */
public class NettyGroupChatServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline cp = ch.pipeline();
        cp.addLast("decode", new StringDecoder());
        cp.addLast("encode", new StringEncoder());
        cp.addLast("MyHandler", new NettyGroupChatServerHandler());
    }

}
