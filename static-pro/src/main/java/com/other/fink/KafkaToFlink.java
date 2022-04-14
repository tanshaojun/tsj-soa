package com.other.fink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.util.Collector;

/**
 * Created by 79073 on 2019/7/15.
 */
public class KafkaToFlink {

    /**
     * 启动参数：--bootstrap.servers localhost:9092 --topic weblog --group.id test-consumer-group
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        ParameterTool parameterTool = ParameterTool.fromArgs(args);
        DataStream<String> dataStream = env.addSource(new FlinkKafkaConsumer<String>(parameterTool.getRequired("topic"), new SimpleStringSchema(), parameterTool.getProperties()));
        DataStream<WordWithCount> windowCounts = dataStream.rebalance().flatMap(new FlatMapFunction<String, WordWithCount>() {
            public void flatMap(String value, Collector<WordWithCount> out) {
                System.out.println("接收到kafka数据：" + value);
                for (String word : value.split("\\s")) {
                    out.collect(new WordWithCount(word, 1L));
                }
            }
        }).keyBy("word")
                .timeWindow(Time.seconds(2))
                .reduce(new ReduceFunction<WordWithCount>() {
                    public WordWithCount reduce(WordWithCount a, WordWithCount b) {
                        return new WordWithCount(a.word, a.count + b.count);
                    }
                });
        windowCounts.print().setParallelism(1);
        env.execute("KafkaToFlink");
    }

    public static class WordWithCount {
        public String word;
        public long count;

        public WordWithCount() {
        }

        public WordWithCount(String word, long count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return word + " : " + count;
        }
    }
}