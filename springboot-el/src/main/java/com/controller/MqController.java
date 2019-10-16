//package com.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.jms.JMSException;
//import javax.jms.Queue;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//import javax.jms.Topic;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@Component
//@EnableScheduling
//public class MqController {
//    @Autowired
//    private JmsTemplate jmsTemplate;
//
//    @Autowired
//    private Queue queue;
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Autowired
//    private Topic topic;
//    private static AtomicInteger atomicInteger1 = new AtomicInteger(100);
//
//    @Scheduled(fixedDelay = 3000)
//    public void send() {
//        System.out.println(">> send !!!");
//        jmsTemplate.convertAndSend(this.queue, String.valueOf(atomicInteger1.addAndGet(1)));
//    }
//
//    @JmsListener(destination = "mvp.queue", containerFactory = "jmsListenerContainerQueue")
//    public void receiveQueue(String text) {
//        System.out.println("toqueue->:" + text);
//    }
//
//
////----------------------------------------------------------------------------------------------------------------------
//
//
//    private static AtomicInteger atomicInteger = new AtomicInteger(0);
//
//    @Scheduled(fixedDelay = 3000)
//    public void topicSend() {
//        System.out.println(">> topicSend !!!");
//        jmsTemplate.convertAndSend(this.topic, String.valueOf(atomicInteger.addAndGet(1)));
//    }
//
//    @JmsListener(destination = "mvp.topic", containerFactory = "jmsListenerContainerTopic")
//    public void topicReceiveQueue1(String text) {
//        System.out.println("topicReceiveQueue1>> {}" + text);
//
//    }
//
//    @JmsListener(destination = "mvp.topic", containerFactory = "jmsListenerContainerTopic")
//    public void topicReceiveQueue2(String text) {
//        System.out.println("topicReceiveQueue2>> {}" + text);
//    }
//
//    @JmsListener(destination = "mvp.topic", containerFactory = "jmsListenerContainerTopic")
//    public void topicReceiveQueue3(String text) {
//        System.out.println("topicReceiveQueue3>> {}" + text);
//    }
//
//
////        SimpleMailMessage message = new SimpleMailMessage();
////        message.setFrom("767650993@qq.com");
////        message.setTo("867388643@qq.com");
////        message.setSubject("邮件轰炸");
////        message.setText("邮件轰炸，哈哈");
////        mailSender.send(message);
//}
