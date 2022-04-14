package com.other.io.netty.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/17 16:01
 */
public class NettyWebSocketServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //基于http协议，使用http编码解码
        pipeline.addLast(new HttpServerCodec());
        //以块的方式写
        pipeline.addLast(new ChunkedWriteHandler());
        //http发送数据是分段传输，HttpObjectAggregator可以聚合多个段
        pipeline.addLast(new HttpObjectAggregator(8192));
        //将http协议升级为ws协议，保持长连接
        pipeline.addLast(new WebSocketServerProtocolHandler("/websocket"));
        //自定义handler
        pipeline.addLast(new NettyWebSocketServerHandler());
    }
}
