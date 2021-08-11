package com.netty.rpc.client;

import com.netty.rpc.*;
import com.netty.rpc.endecode.RpcDecoder;
import com.netty.rpc.endecode.RpcEncoder;
import com.netty.rpc.seriallzer.JSONSerializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import javax.annotation.PreDestroy;

/**
 * @Author tansj
 * @Date 2021/8/10 下午2:45
 * @Version 1.0
 */
public class NettyClient {
    private EventLoopGroup eventLoopGroup;
    private Channel channel;
    private ClientHandler clientHandler;
    private String host;
    private Integer port;

    public NettyClient(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public void connect() throws InterruptedException {
        clientHandler = new ClientHandler();
        eventLoopGroup = new NioEventLoopGroup();
        //启动类
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                //指定传输使用的Channel
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        //添加编码器
                        pipeline.addLast(new RpcEncoder(RpcRequest.class, new JSONSerializer()));
                        //添加解码器
                        pipeline.addLast(new RpcDecoder(RpcResponse.class, new JSONSerializer()));
                        //请求处理类
                        pipeline.addLast(clientHandler);
                    }
                });
        /**
         * 同步获取Netty连接
         */
        channel = bootstrap.connect(host, port).sync().channel();
    }

    /**
     * 发送消息
     *
     * @param request
     * @return
     */
    public RpcResponse send(final RpcRequest request) {
        try {
            channel.writeAndFlush(request).await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return clientHandler.getRpcResponse(request.getRequestId());
    }

    @PreDestroy
    public void close() {
        eventLoopGroup.shutdownGracefully();
        channel.closeFuture().syncUninterruptibly();
    }
}
