package com.other.io.netty.rpc.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 16:30
 */
public class NettyRpcClient {

    private final static Logger logger = LoggerFactory.getLogger(NettyRpcClient.class);

    private static ExecutorService executorService =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private NettyRpcClientHandler client;

    private String hostName = "127.0.0.1";
    private int port = 8989;


    public Object getBean(final Class<?> clazz) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[]{clazz},
                (proxy, method, args) -> {
                    if (client == null) {
                        initNettyRpcClient();
                    }
                    client.setPara(args[0] + "");
                    return executorService.submit(client).get();
                });
    }

    private void initNettyRpcClient() {
        client = new NettyRpcClientHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(client);
                        }
                    });
            ChannelFuture cf = bootstrap.connect(hostName, port).sync();
            logger.info("客户端启动成功..........");
            cf.channel().closeFuture().sync();
        } catch (Exception e) {
            group.shutdownGracefully();
        }
    }

}
