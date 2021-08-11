package com.shardjdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;
import io.shardingsphere.api.algorithm.sharding.hint.HintShardingAlgorithm;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;
import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.api.config.strategy.NoneShardingStrategyConfiguration;
import io.shardingsphere.core.constant.transaction.TransactionType;
import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import io.shardingsphere.core.keygen.KeyGenerator;
import io.shardingsphere.core.transaction.TransactionTypeHolder;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

/**
 * @Author tansj
 * @Date 2021/8/3 上午10:54
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = "com.bxl.dao.shardingDao", sqlSessionTemplateRef = "shardingSqlSessionTemplate")
public class DataSourceConfig {
    //数据源、分库分表总体配置

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    //这里直接注入你项目中配置的数据源
    @Resource
    private DataSource dataSourceOne;

    @Resource
    private DataSource dataSourceTwo;

    //注释掉的先不用看，后边会介绍
    @Bean(name = "shardingDataSource")
    public DataSource dataSource() throws SQLException {

        TransactionTypeHolder.set(TransactionType.LOCAL);
        //1、指定需要分库分表的数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("ds0", dataSourceOne);
        dataSourceMap.put("ds1", dataSourceTwo);
        //2、分库分表配置
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        //2.1、配置默认自增主键生成器
        shardingRuleConfig.setDefaultKeyGenerator(new DefaultKeyGenerator());
        //2.2、配置各个表的分库分表策略，这里只配了一张表的就是t_order
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        //2.3、配置绑定表规则列表,级联绑定表代表一组表，这组表的逻辑表与实际表之间的映射关系是相同的
//        shardingRuleConfig.getBindingTableGroups().add("t_order","t_order_item");
        //2.4、配置广播表规则列表,利用广播小表提高性能
//        shardingRuleConfig.getBroadcastTables().add("t_config");
        //2.5、配置默认分表规则
        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new NoneShardingStrategyConfiguration());
        //2.6、配置默认分库规则(不配置分库规则,则只采用分表规则)
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new NoneShardingStrategyConfiguration());
        //2.7、配置默认数据源
        shardingRuleConfig.setDefaultDataSourceName("ds0");
        //2.8、配置读写分离规则
//        shardingRuleConfig.setMasterSlaveRuleConfigs();

        //3、属性配置项，可以为以下属性
        Properties propertie = new Properties();
        //是否打印SQL解析和改写日志
        propertie.setProperty("sql.show", Boolean.TRUE.toString());
        //用于SQL执行的工作线程数量，为零则表示无限制
        propertie.setProperty("executor.size", "4");
        //每个物理数据库为每次查询分配的最大连接数量
        propertie.setProperty("max.connections.size.per.query", "1");
        //是否在启动时检查分表元数据一致性
        propertie.setProperty("check.table.metadata.enabled", "false");

        //4、用户自定义属性
        Map<String, Object> configMap = new HashMap<>();
        configMap.put("effect", "分库分表");
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, configMap, propertie);

        //5、数据治理
        //5.1、配置注册中心
//        RegistryCenterConfiguration regConfig = new RegistryCenterConfiguration();
//        regConfig.setServerLists("localhost:2181");
//        regConfig.setNamespace("sharding-sphere-orchestration");
        //regConfig.setDigest("data-centre");
        //5.2、配置数据治理
//        OrchestrationConfiguration orchConfig = new OrchestrationConfiguration("orchestration-sharding-data-source", regConfig, true);
        //5.3、获取数据源对象
//        DataSource dataSource = OrchestrationShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, configMap, propertie, orchConfig);
        return dataSource;
    }

    @Bean(name = "shardingSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactorySharding(@Qualifier("shardingDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml"));
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/shardingMapper/**/*.xml"));
        return bean.getObject();
    }

    //本地事务
    @Bean(name = "shardingTransactionManagerLOCAL")
    public PlatformTransactionManager transactionManagerLocal(@Qualifier("shardingDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

//XA事务
//    @Bean(name = "shardingTransactionManagerXA")
//    public ShardingTransactionManager transactionManagerXA(@Qualifier("shardingDataSource") DataSource dataSource) {
//        return new AtomikosTransactionManager();
//    }

    @Bean(name = "shardingSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplateThree(@Qualifier("shardingSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    /**
     * Sharding提供了5种分片策略：
     * StandardShardingStrategyConfiguration:标准分片策略, 提供对SQL语句中的=, IN和BETWEEN AND的分片操作支持
     * ComplexShardingStrategyConfiguration:复合分片策略, 提供对SQL语句中的=, IN和BETWEEN AND的分片操作支持。
     * InlineShardingStrategyConfiguration:Inline表达式分片策略, 使用Groovy的Inline表达式，提供对SQL语句中的=和IN的分片操作支持
     * HintShardingStrategyConfiguration:通过Hint而非SQL解析的方式分片的策略
     * NoneShardingStrategyConfiguration:不分片的策略
     * Sharding提供了以下4种算法接口：
     * PreciseShardingAlgorithm
     * RangeShardingAlgorithm
     * HintShardingAlgorithm
     * ComplexKeysShardingAlgorithm
     *
     * @return
     */
    TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration();
        //1、指定逻辑索引(oracle/PostgreSQL需要配置)
//        result.setLogicIndex("order_id");
        //2、指定逻辑表名
        result.setLogicTable("t_order");
        //3、指定映射的实际表名
        result.setActualDataNodes("ds${0..1}.t_order_${0..1}");
        //4、配置分库策略,缺省表示使用默认分库策略
        result.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "ds${user_id % 2}"));
        //result.setDatabaseShardingStrategyConfig(new HintShardingStrategyConfiguration(new OrderDataBaseHintShardingAlgorithm()));
        //5、配置分表策略,缺省表示使用默认分表策略
        result.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_${order_id % 2}"));
        //result.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("order_id",new orderPreciseShardingAlgorithm(),new orderRangeShardingAlgorithm()));
        //result.setTableShardingStrategyConfig(new ComplexShardingStrategyConfiguration("order_id,user_id",new orderComplexKeysShardingAlgorithm()));
        //result.setTableShardingStrategyConfig(new HintShardingStrategyConfiguration(new OrderTableHintShardingAlgorithm()));
        //6、指定自增字段以及key的生成方式
        result.setKeyGeneratorColumnName("order_id");
        result.setKeyGenerator(new DefaultKeyGenerator());
        return result;
    }


    //PreciseShardingAlgorithm接口实现（用于处理 = 和 in 的路由）
    class orderPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
        @Override
        public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
//            logger.info("collection:" + JSON.toJSONString(collection) + ",preciseShardingValue:" + JSON.toJSONString(preciseShardingValue));
            for (String name : collection) {
                if (name.endsWith(preciseShardingValue.getValue() % collection.size() + "")) {
                    logger.info("return name:" + name);
                    return name;
                }
            }
            return null;
        }
    }


    //RangeShardingAlgorithm接口实现（用于处理BETWEEN AND分片），这里的核心是找出这个范围的数据分布在那些表(库)中
    class orderRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {
        @Override
        public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
//            logger.info("Range collection:" + JSON.toJSONString(collection) + ",rangeShardingValue:" + JSON.toJSONString(rangeShardingValue));
            Collection<String> collect = new ArrayList<>();
            Range<Long> valueRange = rangeShardingValue.getValueRange();
            for (Long i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {
                for (String each : collection) {
                    if (each.endsWith(i % collection.size() + "")) {
                        collect.add(each);
                    }
                }
            }
            return collect;
        }
    }


    //ComplexShardingStrategy支持多分片键
    class orderComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm {
        @Override
        public Collection<String> doSharding(Collection<String> collection, Collection<ShardingValue> shardingValues) {
//            logger.info("collection:" + JSON.toJSONString(collection) + ",shardingValues:" + JSON.toJSONString(shardingValues));
            Collection<Long> orderIdValues = getShardingValue(shardingValues, "order_id");
            Collection<Long> userIdValues = getShardingValue(shardingValues, "user_id");
            List<String> shardingSuffix = new ArrayList<>();
            /**例如：根据 user_id + order_id 双分片键来进行分表*/
            //Set<List<Integer>> valueResult = Sets.cartesianProduct(userIdValues, orderIdValues);
            for (Long userIdVal : userIdValues) {
                for (Long orderIdVal : orderIdValues) {
                    String suffix = userIdVal % 2 + "_" + orderIdVal % 2;
                    collection.forEach(x -> {
                        if (x.endsWith(suffix)) {
                            shardingSuffix.add(x);
                        }
                    });
                }
            }
            return shardingSuffix;
        }

        private Collection<Long> getShardingValue(Collection<ShardingValue> shardingValues, final String key) {
            Collection<Long> valueSet = new ArrayList<>();
            Iterator<ShardingValue> iterator = shardingValues.iterator();
            while (iterator.hasNext()) {
                ShardingValue next = iterator.next();
                if (next instanceof ListShardingValue) {
                    ListShardingValue value = (ListShardingValue) next;
                    /**例如：根据user_id + order_id 双分片键来进行分表*/
                    if (value.getColumnName().equals(key)) {
                        return value.getValues();
                    }
                }
            }
            return valueSet;
        }
    }

    //表的强制分片策略
    class OrderTableHintShardingAlgorithm implements HintShardingAlgorithm {
        @Override
        public Collection<String> doSharding(Collection<String> collection, ShardingValue shardingValue) {
//            logger.info("collection:" + JSON.toJSONString(collection) + ",shardingValues:" + JSON.toJSONString(shardingValue));
            Collection<String> result = new ArrayList<>();
            String logicTableName = shardingValue.getLogicTableName();
            ListShardingValue<Integer> listShardingValue = (ListShardingValue<Integer>) shardingValue;
            List<Integer> list = Lists.newArrayList(listShardingValue.getValues());
            String res = logicTableName + "_" + list.get(0);
            result.add(res);
            return result;
        }
    }

    //库的强制分片策略
    class OrderDataBaseHintShardingAlgorithm implements HintShardingAlgorithm {
        @Override
        public Collection<String> doSharding(Collection<String> collection, ShardingValue shardingValue) {
//            logger.info("collection:" + JSON.toJSONString(collection) + ",shardingValues:" + JSON.toJSONString(shardingValue));
            Collection<String> result = new ArrayList<>();
            ListShardingValue<Integer> listShardingValue = (ListShardingValue<Integer>) shardingValue;
            List<Integer> list = Lists.newArrayList(listShardingValue.getValues());
            for (String db : collection) {
                if (db.endsWith(list.get(0).toString())) {
                    result.add(db);
                }
            }
            return result;
        }
    }

    //分布式唯一主键
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new DefaultKeyGenerator();
    }

}
