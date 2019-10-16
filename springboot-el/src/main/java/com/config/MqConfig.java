//package com.config;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.RedeliveryPolicy;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.apache.activemq.command.ActiveMQTopic;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
//import org.springframework.jms.config.JmsListenerContainerFactory;
//import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
//import org.springframework.jms.core.JmsTemplate;
//
//import javax.jms.Queue;
//import javax.jms.Topic;
//
//
//@Configuration
//public class MqConfig {
//
//    /**
//     * 队列
//     *
//     * @return
//     */
//    @Bean
//    public Queue queue() {
//        return new ActiveMQQueue("mvp.queue");
//    }
//
//    /**
//     * 发布订阅
//     *
//     * @return
//     */
//    @Bean
//    public Topic topic() {
//        return new ActiveMQTopic("mvp.topic");
//    }
//
//    /**
//     * 配置topic消费containerFactory
//     *
//     * @param connectionFactory
//     * @return
//     */
//    @Bean("jmsListenerContainerTopic")
//    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory) {
//        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
//        factory.setPubSubDomain(true);
//        factory.setConnectionFactory(connectionFactory);
//        return factory;
//    }
//
//    /**
//     * 配置队列消费containerFactory
//     *
//     * @param connectionFactory
//     * @return
//     */
//    @Bean("jmsListenerContainerQueue")
//    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory) {
//        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
//        bean.setConnectionFactory(connectionFactory);
//        return bean;
//    }
//
////
////    @Bean
////    public ActiveMQConnectionFactory activeMQConnectionFactory(@Value("${spring.activemq.broker-url}") String url,
////                                                               RedeliveryPolicy redeliveryPolicy) {
////        ActiveMQConnectionFactory activeMQConnectionFactory =
////                new ActiveMQConnectionFactory(
////                        "admin",
////                        "admin",
////                        url);
////        activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy);
////        return activeMQConnectionFactory;
////    }
//    //AUTO_ACKNOWLEDGE = 1    自动确认
//    //CLIENT_ACKNOWLEDGE = 2    客户端手动确认
//    //DUPS_OK_ACKNOWLEDGE = 3    自动批量确认
//    //SESSION_TRANSACTED = 0    事务提交并确认
//    //INDIVIDUAL_ACKNOWLEDGE = 4    单条消息确认 activemq 独有
//
////    @Bean
////    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory activeMQConnectionFactory) {
////        JmsTemplate jmsTemplate = new JmsTemplate();
////        //进行持久化配置 1表示非持久化，2表示持久化
////        jmsTemplate.setDeliveryMode(2);
////        jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
////        //此处可不设置默认，在发送消息时也可设置队列
//////        jmsTemplate.setDefaultDestination(queue);
////        //客户端签收模式
////        jmsTemplate.setSessionAcknowledgeMode(2);
////        return jmsTemplate;
////    }
//
////    /**
////     * 重发机制
////     *
////     * @return
////     */
////    @Bean
////    public RedeliveryPolicy redeliveryPolicy() {
////        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
////        //是否在每次尝试重新发送失败后,增长这个等待时间
////        redeliveryPolicy.setUseExponentialBackOff(true);
////        //重发次数,默认为6次   这里设置为10次
////        redeliveryPolicy.setMaximumRedeliveries(10);
////        //重发时间间隔,默认为1秒
////        redeliveryPolicy.setInitialRedeliveryDelay(1);
////        //第一次失败后重新发送之前等待500毫秒,第二次失败再等待500 * 2毫秒,这里的2就是value
////        redeliveryPolicy.setBackOffMultiplier(2);
////        //是否避免消息碰撞
////        redeliveryPolicy.setUseCollisionAvoidance(false);
////        //设置重发最大拖延时间-1 表示没有拖延只有UseExponentialBackOff(true)为true时生效
////        redeliveryPolicy.setMaximumRedeliveryDelay(-1);
////        return redeliveryPolicy;
////    }
//}
