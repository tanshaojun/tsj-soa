package com.rocketmq.server;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * @Author tansj
 * @Date 2021/8/11 下午2:21
 * @Version 1.0
 */
public class MessageReceiveService implements MessageListenerConcurrently {
    private static Logger logger = LoggerFactory.getLogger(MessageReceiveService.class);

    @Value("${accept_system_interface}")
    private String acceptSystemInterface;

    /**
     * 消费rocketMQ上的消息
     *
     * @param msgs    rocketMQ消息
     * @param context 消息消费上下文
     * @return 消息处理状态
     */
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        // 判断消息类型
        return handleHcpMessage(msgs, context);
    }

    /**
     * @param msgs    当前消息（组）
     * @param context 消息消费上下文
     */
    private ConsumeConcurrentlyStatus handleHcpMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        for (MessageExt msg : msgs) {
            // 消息校验与序列化
            try {
                String message = new String(msg.getBody(), RemotingHelper.DEFAULT_CHARSET);
                System.out.println(message);
            } catch (Exception e) {
                e.printStackTrace();
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

}
