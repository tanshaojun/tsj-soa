package com.other.io.reactor;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author tansj
 * @Date 2021/9/6 11:23 上午
 * @Version 1.0
 */
@Slf4j
public class Acceptor implements Runnable {

    private static final BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();

    private static final ThreadPoolExecutor mainExecutor = new ThreadPoolExecutor(
            10,
            10,
            100,
            TimeUnit.MILLISECONDS,
            blockingQueue,
            new ThreadFactory() {
                private AtomicInteger threadIndex = new AtomicInteger(0);

                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "main-reactor-thread-" + this.threadIndex.incrementAndGet());
                }
            }
    );


    @Override
    public void run() {
        ServerSocketChannel channel;
        try {
            channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress(1212));
            //转发到main-reactor
            dispatch(channel);
            log.info("server is running.....");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void dispatch(ServerSocketChannel channel) {
        mainExecutor.submit(new MainReactor(channel));
    }

}
