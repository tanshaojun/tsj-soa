package com.other.io.groupchat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/10 18:07
 */
public class GroupChatServer {

    private final static Logger logger = LoggerFactory.getLogger(GroupChatServer.class);

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private final static int PORT = 8989;

    public GroupChatServer() {
        try {
            //获取serverSocketChannel
            this.serverSocketChannel = ServerSocketChannel.open();
            //绑定端口
            this.serverSocketChannel.bind(new InetSocketAddress(PORT));
            //设置非阻塞
            this.serverSocketChannel.configureBlocking(false);
            this.selector = Selector.open();
            //将serverSocketChannel注册到selector上，监听事件为OP_ACCEPT
            this.serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listen() {
        while (true) {
            try {
                int count = this.selector.select();
                if (count > 0) {
                    Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        //连接事件
                        if (selectionKey.isAcceptable()) {
                            ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                            SocketChannel socketChannel = channel.accept();
                            //设置非阻塞
                            socketChannel.configureBlocking(false);
                            logger.info("{}上线了", socketChannel.getRemoteAddress());
                            //将新连接注册到selector并监听OP_READ
                            socketChannel.register(this.selector, SelectionKey.OP_READ);
                        }
                        //读数据事件
                        if (selectionKey.isReadable()) {
                            read(selectionKey);
                        }
                        iterator.remove();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void read(SelectionKey key) {
        SocketChannel channel = (SocketChannel) key.channel();
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = channel.read(byteBuffer);
            if (read > 0) {
                String msg = new String(byteBuffer.array());
                logger.info("{}说：{}", channel.getRemoteAddress(), msg);
                forward(channel, channel.getRemoteAddress() + "说：" + msg);
            }
        } catch (Exception e) {
            try {
                logger.info("{}下线了", channel.getRemoteAddress());
                //取消注册
                key.cancel();
                //关闭通道
                channel.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    /**
     * 转发消息
     *
     * @param socketChannel
     * @param msg
     * @throws IOException
     */
    private void forward(SocketChannel socketChannel, String msg) throws IOException {
        logger.info("服务器转发消息中............");
        for (SelectionKey key : this.selector.keys()) {
            Channel channel = key.channel();
            if (channel instanceof SocketChannel && channel != socketChannel) {
                SocketChannel sc = (SocketChannel) channel;
                sc.write(ByteBuffer.wrap(msg.getBytes()));
            }
        }
    }

    public static void main(String[] args) {
        GroupChatServer server = new GroupChatServer();
        server.listen();
    }

}
