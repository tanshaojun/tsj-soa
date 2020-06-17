package com.other.io.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/16 16:26
 */
public class TestHttpNettyServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final static Logger logger = LoggerFactory.getLogger(TestHttpNettyServerChannelInitializer.class);

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //设置编码解码
        ch.pipeline().addLast(new HttpServerCodec());
        ch.pipeline().addLast(new TestHttpNettyServerHandler());
    }
}
