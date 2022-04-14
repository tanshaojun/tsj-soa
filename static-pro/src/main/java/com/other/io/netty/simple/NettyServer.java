package com.other.io.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/15 10:37
 */
public class NettyServer {

    public static void main(String[] args) throws Exception {
        int nThreads = 10;

        //处理连接请求
        EventLoopGroup bossGroup = new NioEventLoopGroup(nThreads, new ThreadFactory() {
            private AtomicInteger threadIndex = new AtomicInteger(0);
            private int threadTotal = nThreads;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, String.format("bossGroup%d_%d", threadTotal, this.threadIndex.incrementAndGet()));
            }
        });
        //与客户端业务处理
        EventLoopGroup workGroup = new NioEventLoopGroup(nThreads, new ThreadFactory() {
            private AtomicInteger threadIndex = new AtomicInteger(0);
            private int threadTotal = nThreads;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, String.format("workGroup%d_%d", threadTotal, this.threadIndex.incrementAndGet()));
            }
        });

        try {

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)//设置channel
                    .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列保持连接数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保存活跃连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyServerChannelHandler());
                        }
                    });

            //绑定端口
            ChannelFuture cf = bootstrap.bind(8989).sync();

            //对关闭通道进行监听
            cf.channel().closeFuture().sync();

        } catch (Exception e) {

        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

}
