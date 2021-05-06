package com.other.fink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * @Author tansj
 * @Date 2021-04-23 13:59
 * @Version 1.0
 */
public class BatchWC {
    public static void main(String[] args) throws Exception {
        //1.获取执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //2.读取源文件
        DataSource<String> textFile = env.readTextFile("/Users/tanshaojun/project/tsj-soa/springboot/src/main/resources/hello.txt");
        //3.读取当前行，并进行切割
        textFile.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                String[] values = s.toLowerCase().split(",");
                for (String value : values) {
                    if (value.length() > 0) {
                        collector.collect(new Tuple2<String, Integer>(value, 1));
                    }
                }
            }
        })
                //4.分组
                .groupBy(0)
                //5.求和
                .sum(1)
                //6.打印（sink）
                .print();
    }
}
