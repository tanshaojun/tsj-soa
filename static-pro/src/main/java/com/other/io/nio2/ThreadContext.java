package com.other.io.nio2;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author tansj
 * @Date 2022/2/8 10:31 上午
 * @Version 1.0
 */
public class ThreadContext {
    /**
     * 记录当前使用过的选择器
     */
    public static final Set<MyNioEventLoop> RUN_SELECT = new HashSet<>();
}
