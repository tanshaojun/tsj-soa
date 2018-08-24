package com.controller;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class JM {
    public static void main(String[] args) throws GeneralSecurityException, MessagingException {
        final Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.password", "xusrxvdmlawabead");
        props.put("mail.smtp.starttls.enable", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("767650993@qq.com", "love000000");
            }
        };
        Session mailSession = Session.getInstance(props, authenticator);
        mailSession.setDebug(true);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("767650993@qq.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("767650994@qq.com"));
        message.setSubject("测试");
        message.setContent("1123645", "text/html;charset=UTF-8");
        Transport.send(message);
        System.out.println("Sent message successfully....from runoob.com");
    }
}
