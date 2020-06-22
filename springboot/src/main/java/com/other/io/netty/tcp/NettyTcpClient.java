package com.other.io.netty.tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 10:35
 */
public class NettyTcpClient {

    private final static Logger logger = LoggerFactory.getLogger(NettyTcpClient.class);

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new NettyTcpClientChannelInitializer());
            ChannelFuture cf = bootstrap.connect(InetAddress.getLocalHost(), 8989).sync();
            cf.channel().closeFuture().sync();
        } catch (Exception e) {

        } finally {
            group.shutdownGracefully();
        }
    }
}
