package com.other.io.nio;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/18 14:32
 */
public class NIOClient {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        boolean connect = socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8080));
        if (!connect) {
            while (!socketChannel.finishConnect()){
                System.out.println(111111111);
            }
        }
        String str = "123456";
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
        socketChannel.write(byteBuffer);
        while (true) {
        }
    }

}
