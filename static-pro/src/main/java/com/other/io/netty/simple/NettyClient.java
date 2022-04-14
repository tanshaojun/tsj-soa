package com.other.io.netty.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetAddress;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/15 10:37
 */
public class NettyClient {

    public static void main(String[] args) {

        EventLoopGroup work = new NioEventLoopGroup();

        try {

            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(work)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyClientChannelHandler());
                        }
                    });

            ChannelFuture cf = bootstrap.connect(InetAddress.getLocalHost(), 8989).sync();

            cf.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            work.shutdownGracefully();
        }

    }

}
