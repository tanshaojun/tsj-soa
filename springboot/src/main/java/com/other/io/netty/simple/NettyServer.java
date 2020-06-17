package com.other.io.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/15 10:37
 */
public class NettyServer {

    public static void main(String[] args) throws Exception {

        //处理连接请求
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //与客户端业务处理
        EventLoopGroup workGroup = new NioEventLoopGroup();

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
