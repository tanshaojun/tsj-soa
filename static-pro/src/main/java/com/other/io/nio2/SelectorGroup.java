package com.other.io.nio2;

import java.io.IOException;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 选择器组
 *
 * @Author tansj
 * @Date 2022/2/8 10:30 上午
 * @Version 1.0
 */
public class SelectorGroup {

    private final List<MyNioEventLoop> SELECTOR_GROUP = new ArrayList<>(8);
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private final static AtomicInteger IDX = new AtomicInteger();

    /**
     * 初始化选择器
     *
     * @param count 处理器数量
     * @throws IOException 异常信息
     */
    public SelectorGroup(int count) throws IOException {

        for (int i = 0; i < count; i++) {
            Selector open = Selector.open();
            MyNioEventLoop myNioEventLoop = new MyNioEventLoop(open);
            SELECTOR_GROUP.add(myNioEventLoop);
        }
    }

    public SelectorGroup() throws IOException {
        this(AVAILABLE_PROCESSORS << 1);
    }

    /**
     * 轮询获取一个选择器
     *
     * @return 返回一个选择器
     */
    public MyNioEventLoop next() {
        int andIncrement = IDX.getAndIncrement();
        int length = SELECTOR_GROUP.size();

        return SELECTOR_GROUP.get(Math.abs(andIncrement % length));
    }
}
