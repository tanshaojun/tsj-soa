package com.other.io.reactor;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * @Author tansj
 * @Date 2021/9/6 11:54 上午
 * @Version 1.0
 */
@Slf4j
public class SubReactorThread extends Thread {

    private ExecutorService businessExecutor;

    private Selector selector;

    private List<NioTask> list = new ArrayList<>();

    public SubReactorThread(ExecutorService businessExecutor) {
        this.businessExecutor = businessExecutor;
        try {
            this.selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void register(NioTask task) {
        if (null != task) {
            list.add(task);
        }
    }

    @Override
    public void run() {
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
                SelectionKey key = it.next();
                try {
                    SocketChannel channel = (SocketChannel) key.channel();
                    if (key.isWritable()) {
                        ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                        channel.write(byteBuffer);
                        channel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        channel.read(byteBuffer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
