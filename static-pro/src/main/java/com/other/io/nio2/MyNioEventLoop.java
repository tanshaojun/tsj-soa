package com.other.io.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * nio事件处理器
 *
 * @Author tansj
 * @Date 2022/2/8 10:29 上午
 * @Version 1.0
 */
public class MyNioEventLoop implements Runnable {
    private static final ByteBuffer ALLOCATE = ByteBuffer.allocate(128);
    private final Selector selector;
    private final LinkedBlockingQueue<Runnable> linkedBlockingQueue;

    public MyNioEventLoop(Selector selector) {
        this.selector = selector;
        linkedBlockingQueue = new LinkedBlockingQueue<>();
    }

    public Selector getSelector() {
        return selector;
    }

    public LinkedBlockingQueue<Runnable> getLinkedBlockingQueue() {
        return linkedBlockingQueue;
    }

    //忽略hashCode和equals

    /**
     * 任务处理器
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                //进行事件选择  这里我们只处理读事件
                if (selector.select() > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    //处理读事件
                    while (iterator.hasNext()) {
                        SelectionKey next = iterator.next();
                        iterator.remove();
                        if (next.isReadable()) {
                            SocketChannel channel = (SocketChannel) next.channel();
                            int read = channel.read(ALLOCATE);
                            if (read > 0) {
                                System.out.printf("线程%s【%s】发来消-息:", Thread.currentThread().getName(), channel.getRemoteAddress());
                                System.out.println(new String(ALLOCATE.array(), StandardCharsets.UTF_8));
                            } else if (read == -1) {
                                System.out.println("连接断开");
                                channel.close();
                            }
                            ALLOCATE.clear();
                        }
                    }
                    selectionKeys.clear();
                } else {
                    //处理异步任务  进行注册
                    while (!linkedBlockingQueue.isEmpty()) {
                        Runnable take = linkedBlockingQueue.take();
                        //异步事件执行
                        take.run();
                    }
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
