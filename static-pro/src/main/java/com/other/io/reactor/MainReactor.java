package com.other.io.reactor;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author tansj
 * @Date 2021/9/6 11:34 上午
 * @Version 1.0
 */
@Slf4j
public class MainReactor implements Runnable {

    private Selector selector;

    private SubReactorThreadGroup subReactorThreadGroup;

    public MainReactor(ServerSocketChannel channel) {
        try {
            selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        subReactorThreadGroup = new SubReactorThreadGroup();
    }

    @Override
    public void run() {
        log.info("main reactor is running");
        while (!Thread.interrupted()) {
            Set<SelectionKey> selectionKeys = null;
            try {
                selector.select(1000);
                selectionKeys = selector.selectedKeys();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator<SelectionKey> it = selectionKeys.iterator();
            while (it.hasNext()) {
                SelectionKey selectionKey = it.next();
                if (selectionKey.isAcceptable()) {
                    log.info("received client connect");
                    ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                    try {
                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false);
                        subReactorThreadGroup.dispatch(socketChannel);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
