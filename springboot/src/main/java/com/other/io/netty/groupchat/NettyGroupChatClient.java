package com.other.io.netty.groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/16 17:50
 */
public class NettyGroupChatClient {

    private final static Logger logger = LoggerFactory.getLogger(NettyGroupChatServerHandler.class);

    public static void main(String[] args) {
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(work)
                    .channel(NioSocketChannel.class).handler(new NettyGroupChatClientChannelInitializer());
            ChannelFuture cf = bootstrap.connect(InetAddress.getLocalHost(), 8989).sync();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String next = scanner.nextLine();
                write(cf.channel(), next);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            work.shutdownGracefully();
        }
    }

    private static void write(Channel channel, String msg) {
        String address = channel.localAddress().toString();
        logger.info("客户端{}发送消息中..........", address);
        msg = address + "说：" + msg;
        channel.writeAndFlush(Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8));
    }

}
