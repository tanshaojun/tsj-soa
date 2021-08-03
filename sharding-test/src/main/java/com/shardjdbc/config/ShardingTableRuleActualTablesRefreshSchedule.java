package com.shardjdbc.config;


import io.shardingsphere.core.exception.ShardingConfigurationException;
import io.shardingsphere.core.rule.DataNode;
import io.shardingsphere.core.rule.TableRule;
import io.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * @Author tansj
 * @Date 2021/8/2 下午5:16
 * @Version 1.0
 */
@Component
@EnableScheduling
@EnableConfigurationProperties(TableNamesConfig.class)
@Slf4j
public class ShardingTableRuleActualTablesRefreshSchedule {

    @Autowired
    private TableNamesConfig tableNamesConfig;

    @Autowired
    private DataSource dataSource;

    public ShardingTableRuleActualTablesRefreshSchedule() {
    }

    //    @Scheduled(cron = "0 0 0 * * *")
    public void actualTablesRefresh(Integer c) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("---------------------------------");
        ShardingDataSource dataSource = (ShardingDataSource) this.dataSource;
        if (tableNamesConfig.getNames() == null || tableNamesConfig.getNames().length == 0) {
            log.warn("dynamic.table.names为空");
            return;
        }
        for (int i = 0; i < tableNamesConfig.getNames().length; i++) {
            TableRule tableRule = null;
            try {
                tableRule = dataSource.getShardingContext().getShardingRule().getTableRuleByLogicTableName(tableNamesConfig.getNames()[i]);
                System.out.println(tableRule);
            } catch (ShardingConfigurationException e) {
                log.error("逻辑表：{},不存在配置！", tableNamesConfig.getNames()[i]);
            }
            List<DataNode> dataNodes = tableRule.getActualDataNodes();

            Field actualDataNodesField = TableRule.class.getDeclaredField("actualDataNodes");
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(actualDataNodesField, actualDataNodesField.getModifiers() & ~Modifier.FINAL);
            actualDataNodesField.setAccessible(true);

            String dataSourceName = dataNodes.get(0).getDataSourceName();
            String logicTableName = tableRule.getLogicTable();
            for (int j = tableNamesConfig.startYear; j <= c; j++) {
                StringBuilder stringBuilder = new StringBuilder(10).append(dataSourceName).append(".").append(logicTableName);
                final int length = stringBuilder.length();
                stringBuilder.setLength(length);
                stringBuilder.append("_" + j);
                DataNode dataNode = new DataNode(stringBuilder.toString());
                dataNodes.add(dataNode);
            }
            actualDataNodesField.set(tableRule, dataNodes);
        }

    }
}

