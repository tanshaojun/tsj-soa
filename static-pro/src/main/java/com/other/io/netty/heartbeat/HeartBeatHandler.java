package com.other.io.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/17 11:51
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

    private final static Logger logger = LoggerFactory.getLogger(HeartBeatHandler.class);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if (evt instanceof IdleStateEvent) {

            IdleStateEvent event = (IdleStateEvent) evt;
            switch (event.state()) {
                case READER_IDLE:
                    logger.info("读事件长时间未发生，心跳检测中.............");
                    break;
                case WRITER_IDLE:
                    logger.info("写事件长时间未发生，心跳检测中.............");
                    break;
                case ALL_IDLE:
                    logger.info("读写事件长时间未发生，心跳检测中.............");
                    break;
            }

        }

    }

}
