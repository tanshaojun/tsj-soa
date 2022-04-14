package com.other.io.nio2;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * 反应器
 *
 * @Author tansj
 * @Date 2022/2/8 10:33 上午
 * @Version 1.0
 */
public class Reactor implements Runnable {

    private final Selector selector;

    public Reactor(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            System.out.println("服务启动成功");
            while (!Thread.currentThread().isInterrupted()) {
                //等待连接事件
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    iterator.remove();
                    //进行数据分发
                    dispatch(next);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将新连接分发到新连接接入器
     *
     * @param next 所有事件主键
     */
    private void dispatch(SelectionKey next) {
        Runnable attachment = (Runnable) next.attachment();
        if (attachment != null) {
            attachment.run();
        }
    }

}
