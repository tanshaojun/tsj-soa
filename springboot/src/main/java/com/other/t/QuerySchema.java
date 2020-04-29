package com.other.t;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 查询列的描述
 */
@Data
public class QuerySchema {
    /**
     * 以别名为键，val描述查询列z
     */
    private Map<String, Set<String>> aliasColumns = new HashMap<>();

    /**
     * 是否查询全部列
     */
    private boolean selectAll;

    /**
     * 查询的结果列描述
     */
    private List<QueryResult> selectResults = new ArrayList<>();

    /**
     * 排序描述
     */
    private List<QueryResult.ColumnParam> orderByColumns = new ArrayList<>();

    private Map<String, StringBuilder> where = new HashMap<>();


    public void addWhere(String table, String sql) {
        StringBuilder stringBuilder = where.get(table);
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
            where.put(table, stringBuilder);
        }
        stringBuilder.append(sql);
    }

    public StringBuilder getWhereStr(String table) {
        return where.get(table);
    }

    /**
     * 获取sql需要的查询列
     *
     * @param alias
     * @return
     */
    public Set<String> getSelectColumn(String alias) {
        if (selectAll) {
            Set<String> result = new HashSet<>();
            result.add("*");
            return result;
        }
        return aliasColumns.get(alias);
    }

    /**
     * 别名:【查询字段】
     *
     * @param table
     * @param name
     */
    public void addAliasColumn(String table, String name) {
        Set<String> set = aliasColumns.get(table);
        if (CollectionUtils.isEmpty(set)) {
            set = new HashSet<>();
            aliasColumns.put(table, set);
        }
        set.add(name);
    }


    /**
     * 添加排序列
     *
     * @param table
     * @param name
     */
    public void addOrderColumn(String table, String name) {
        orderByColumns.add(new QueryResult.ColumnParam(table, name));
        addAliasColumn(table, name);
    }

    public void addSelectResult(QueryResult selectResult) {
        this.selectResults.add(selectResult);
    }

    /**
     * 查询结果是否存在组合函数
     *
     * @return
     */
    public boolean haveExpr() {
        return selectResults.stream().filter(x -> x.isMethodColumn()).findFirst().isPresent();
    }

    /**
     * 是否存在排序
     * @return
     */
    public boolean haveOrderBy() {
        return CollectionUtils.isEmpty(orderByColumns);
    }

}