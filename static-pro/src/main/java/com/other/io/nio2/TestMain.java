package com.other.io.nio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @Author tansj
 * @Date 2022/2/8 10:34 上午
 * @Version 1.0
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        //创建一个选择器组,传递选择器组的大小,决定使用多少选择器来实现
        SelectorGroup selectorGroup = new SelectorGroup(2);
        //开启一个服务端管道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //开启一个服务端专用的选择器
        Selector selector = Selector.open();
        //设置非阻塞
        serverSocketChannel.configureBlocking(false);
        //创建一个连接器
        Acceptor acceptor = new Acceptor(serverSocketChannel, selectorGroup);
        //将服务端通道注册到服务端选择器上,这里会绑定一个新连接接入器
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT, acceptor);
        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8989));
        //启动处理器
        new Reactor(selector).run();
    }
}
