package com.other.io.reactor;

import lombok.extern.slf4j.Slf4j;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author tansj
 * @Date 2021/9/6 11:47 上午
 * @Version 1.0
 */
@Slf4j
public class SubReactorThreadGroup {

    private SubReactorThread[] ioThreads;

    public SubReactorThreadGroup() {

        ExecutorService businessExecutor = Executors.newFixedThreadPool(10, new ThreadFactory() {

            private AtomicInteger threadIndex = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "business-thread-" + this.threadIndex.getAndIncrement());
            }
        });
        this.ioThreads = new SubReactorThread[10];

        for (int i = 0; i < 10; i++) {
            this.ioThreads[i] = new SubReactorThread(businessExecutor);
            this.ioThreads[i].start();
        }


    }

    public void dispatch(SocketChannel socketChannel) {
        if (null != socketChannel) {
            next().register(new NioTask(socketChannel, SelectionKey.OP_READ));
        }

    }

    protected SubReactorThread next() {
        return this.ioThreads[0];
    }

}
