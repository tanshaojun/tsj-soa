package com.other.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @Author tansj
 * @Date 2021/9/27 4:16 下午
 * @Version 1.0
 */
public class ConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "false");
        props.put("auto.offset.reset", "earliest");
        props.put("max.poll.records", 10);
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, "50");

        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList("user_behavior"));
        int i = 0;
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(3000);
            System.out.println("polls out: " + ++i + "time: " + String.valueOf(System.currentTimeMillis()));

            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("time = %s, partition = %s, offset = %d, key = %s, value = %s%n",
                        String.valueOf(record.timestamp()),
                        record.partition(),
                        record.offset(),
                        record.key(),
                        record.value());
                TimeUnit.SECONDS.sleep(2);
            }
            consumer.commitSync();
        }
    }
}
