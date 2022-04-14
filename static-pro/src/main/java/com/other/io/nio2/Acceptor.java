package com.other.io.nio2;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 连接器
 *
 * @Author tansj
 * @Date 2022/2/8 10:32 上午
 * @Version 1.0
 */
public class Acceptor implements Runnable {

    private final ServerSocketChannel serverSocketChannel;
    private final SelectorGroup selectorGroup;

    public Acceptor(ServerSocketChannel serverSocketChannel, SelectorGroup selectorGroup) {
        this.serverSocketChannel = serverSocketChannel;
        this.selectorGroup = selectorGroup;
    }


    @Override
    public void run() {
        try {
            SocketChannel socketChannel = serverSocketChannel.accept();
            MyNioEventLoop next = selectorGroup.next();

            //向队列追加一个注册任务
            next.getLinkedBlockingQueue().offer(() -> {
                try {
                    //客户端注册为非阻塞
                    socketChannel.configureBlocking(false);
                    //注册到选择器 关注一个读事件
                    socketChannel.register(next.getSelector(), SelectionKey.OP_READ);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            //唤醒对应的任务，让其处理异步任务
            next.getSelector().wakeup();

            System.out.println("检测到连接：" + socketChannel.getRemoteAddress());
            //当当前选择器已经被使用过了  就不再使用了，直接注册就行了
            if (ThreadContext.RUN_SELECT.add(next)) {
                //启动任务
                new Thread(next).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
