package com.other.fink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

/**
 * @Author tansj
 * @Date 2021-04-23 14:08
 * @Version 1.0
 */
public class StreamWC {
    public static void main(String[] args) throws Exception {
        //1.从args中获取端口等参数
        int port = 0;
        try {
            ParameterTool tool = ParameterTool.fromArgs(args);
            port = tool.getInt("port");
        } catch (Exception e) {
            System.err.println("未定义端口，使用默认9999");
            port = 9999;
        }
        //2.获取执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //3.获取数据源
        DataStreamSource<String> source = env.socketTextStream("localhost", port);
        //4.对每行数据进行切割
        source.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                String[] values = s.toLowerCase().split(" ");
                for (String value : values) {
                    if (value.length() > 0) {
                        collector.collect(new Tuple2<String, Integer>(value, 1));
                    }
                }
            }
        })
                //5.分组
                .keyBy(0)
                //6.定时刷新结果
                .timeWindow(Time.seconds(5))
                //7.求和
                .sum(1)
                //8.打印（sink）
                .print()
                //9.设置并行数
                .setParallelism(1);
        //10.提交作业
        env.execute("StreamWC");
    }


}
