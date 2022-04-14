package com.other.io.nio;

import com.other.io.groupchat.GroupChatClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/18 14:32
 */
public class NIOServer {

    private final static Logger logger = LoggerFactory.getLogger(NIOServer.class);

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));

        //设置非阻塞
        serverSocketChannel.configureBlocking(false);

        //获取一个Selector
        Selector selector = Selector.open();

        //将serverSocketChannel注册到selector，注册的事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {

            if (selector.select(1000) == 0) {
                System.out.println("无连接，等待中........");
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                //连接
                if (selectionKey.isAcceptable()) {
                    System.out.println("连接成功");
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    //连接成功获取一个socketChannel
                    SocketChannel socketChannel = server.accept();
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketChannel.getRemoteAddress();
                    logger.info("{}:{}上线了.............", inetSocketAddress.getAddress().getHostAddress(),
                            inetSocketAddress.getPort());
                    //设置socketChannel为非阻塞
                    socketChannel.configureBlocking(false);
                    //将socketChannel注册到selector中，注册事件为OP_READ
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                //读取数据
                if (selectionKey.isReadable()) {
                    System.out.println("读取数据开始.........");
                    //通过selectionKey获取一个socketChannel通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    //通过selectionKey获取一个byteBuffer
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                    //从通道读取数据到socketChannel
                    socketChannel.read(byteBuffer);
                    System.out.println("读取数据为：" + new String(byteBuffer.array()));
                }
                //删除selectionKey
                iterator.remove();
            }
        }
    }

}
