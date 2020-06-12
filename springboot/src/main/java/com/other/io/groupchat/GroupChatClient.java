package com.other.io.groupchat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

import static java.nio.channels.SocketChannel.open;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/10 18:07
 */
public class GroupChatClient {

    private final static Logger logger = LoggerFactory.getLogger(GroupChatClient.class);

    private SocketChannel socketChannel;
    private Selector selector;

    public GroupChatClient() {
        try {
            this.socketChannel = open(new InetSocketAddress("127.0.0.1", 8989));
            this.selector = Selector.open();
            this.socketChannel.configureBlocking(false);
            this.socketChannel.register(this.selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMsg() {
        try {
            int count = this.selector.select();
            if (count > 0) {
                Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isReadable()) {
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        channel.configureBlocking(false);
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        channel.read(byteBuffer);
                        String msg = new String(byteBuffer.array());
                        logger.info("{}", msg);
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMsg(String msg) throws IOException {
        this.socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
    }


    public static void main(String[] args) throws IOException {

        GroupChatClient client = new GroupChatClient();

        new Thread(() -> {
            while (true) {
                client.readMsg();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            client.sendMsg(next);
        }

    }

}
