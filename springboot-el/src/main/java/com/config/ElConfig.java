package com.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA
 * name tan shaojun
 * Date: 2018/8/1
 * Time: 下午9:32
 */
@Configuration
public class ElConfig {

    private static final Log logger = LogFactory.getLog(ElConfig.class);

    /**
     * elk集群地址
     */
    @Value("${elasticsearch.ip}")
    private String hostName;
    /**
     * 端口
     */
    @Value("${elasticsearch.port}")
    private String port;
    /**
     * 集群名称
     */
    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    /**
     * 连接池
     */
    @Value("${elasticsearch.pool}")
    private String poolSize;

    @Bean
    public TransportClient init() {

        TransportClient transportClient = null;
        try {
            // 配置信息
            Settings esSetting = Settings.builder()
                    .put("cluster.name", clusterName)
                    //增加嗅探机制，找到ES集群
                    .put("client.transport.sniff", true)
                    //增加线程池个数，暂时设为5
                    .put("thread_pool.search.size", Integer.parseInt(poolSize))
                    .build();

            transportClient = new PreBuiltTransportClient(esSetting);
            TransportAddress inetSocketTransportAddress = new TransportAddress(InetAddress.getByName(hostName),
                    Integer.valueOf(port));
            transportClient.addTransportAddresses(inetSocketTransportAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            logger.info("初始化bean失败");
        }


        return transportClient;
    }

}
