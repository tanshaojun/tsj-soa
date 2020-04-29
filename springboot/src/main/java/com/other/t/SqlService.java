package com.other.t;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLOrderBy;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLAggregateExpr;
import com.alibaba.druid.sql.ast.expr.SQLAllColumnExpr;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOpExpr;
import com.alibaba.druid.sql.ast.expr.SQLCharExpr;
import com.alibaba.druid.sql.ast.expr.SQLIntegerExpr;
import com.alibaba.druid.sql.ast.expr.SQLPropertyExpr;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.ast.statement.SQLSelectGroupByClause;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectOrderByItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.ast.statement.SQLTableSource;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitorAdapter;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.util.JdbcConstants;
import com.alibaba.druid.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

//@Slf4j
//@Service
public class SqlService {

    /**
     * 解析为物化sql并获取表名
     *
     * @param sql
     * @return
     */
    public SQLStatement parseSql(String sql) {
        List<SQLStatement> sqlStatements = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);
        if (!CollectionUtils.isEmpty(sqlStatements)) {
            // 只处理第一条SQL
            SQLStatement sqlStatement = sqlStatements.get(0);
            if (sqlStatement instanceof SQLSelectStatement) {
                // 查询
                return sqlStatement;
            } else {
                throw new RuntimeException("不支持该类型SQL");
            }
        }

        throw new RuntimeException("SQL错误");
    }


    public static void main(String[] args) {
//        String sql = "select *  from user ,account a where  user.id = a.id and a.id = '3' and user.id = 4 and user.id = a.id  order by a" +
//                ".age,user.id";
//        String sql = "select *  from account a where a.id = '3' and a.age > 4 order by a.age";
//        String sql = "select u1.name,sum(u1.id * (u2.id + u2.id) + (u2.id + u1.id + u2.id)) from u u1,u2 where u1
// .id = u2.id group by u1.name";
//        String sql = "select u1.name,sum(u1.id) as sum from user as u1,account as u2 where u1.id = u2.id group by
// u1.name,u2.accountname order by u1.name,sum(u2.accountname)";
        String sql = "select *  from user ,account a where  a.id = '3'  and a.age > 4  and 2 > user.age or '3' = user.id";

        SqlService sqlService = new SqlService();
        SQLStatement sqlStatement = sqlService.parseSql(sql);
        QuerySchema selectColumn = sqlService.getQuerySchema((SQLSelectStatement) sqlStatement);
        Map<String, String> aliasMap = sqlService.aliasMap((SQLSelectStatement) sqlStatement);
//        Map<String, List<String>> map = sqlService.groupMap((SQLSelectStatement) sqlStatement);
        System.out.println(aliasMap);
        System.out.println(selectColumn.getSelectResults().get(1).getExpr());
    }

    /**
     * 表名->分组字段
     *
     * @param sqlStatement
     * @return
     */
    public Map<String, List<String>> groupMap(SQLSelectStatement sqlStatement) {
        Map<String, List<String>> map = new HashMap<>();
        SQLSelectGroupByClause groupBy = ((MySqlSelectQueryBlock) sqlStatement.getSelect().getQuery()).getGroupBy();
        List<SQLExpr> items = groupBy.getItems();
        for (SQLExpr sqlExpr : items) {
            SQLPropertyExpr sqlExpr1 = (SQLPropertyExpr) sqlExpr;
            String ownerName = sqlExpr1.getOwnernName();
            String name = sqlExpr1.getName();
            List<String> strings = map.get(ownerName);
            if (CollectionUtils.isEmpty(strings)) {
                strings = new ArrayList<>();
                map.put(ownerName, strings);
            }
            strings.add(name);
        }
        return map;
    }


    public SQLExpr getSQLExpr(int state, SQLBinaryOpExpr expr, SQLExpr right) {
        SQLBinaryOpExpr s = (SQLBinaryOpExpr) right;
        SQLExpr where = null;
        if (s.getLeft() instanceof SQLCharExpr || s.getLeft() instanceof SQLIntegerExpr
                || s.getRight() instanceof SQLCharExpr || s.getRight() instanceof SQLIntegerExpr) {
            String ownernName = "";
            if (s.getLeft() instanceof SQLPropertyExpr) {
                //取 owner
                SQLPropertyExpr left = (SQLPropertyExpr) (s.getLeft());
                ownernName = left.getOwnernName();
            } else {
                SQLPropertyExpr right1 = (SQLPropertyExpr) (s.getRight());
                ownernName = right1.getOwnernName();
            }
            String name = expr.getOperator().getName();
            String ss = right.toString();
            String res = ss + name;
            System.out.println(ownernName + "---->" + res);
            if (0 == state) {
                where = expr.getLeft();
            } else {
                where = expr.getRight();
            }
        }
        return where;
    }

    /**
     * 解析sql中的查询列
     *
     * @param sqlStatement
     * @return
     */
    public QuerySchema getQuerySchema(SQLSelectStatement sqlStatement) {
        QuerySchema result = new QuerySchema();
        MySqlSelectQueryBlock query = (MySqlSelectQueryBlock) sqlStatement.getSelect().getQuery();
        SQLTableSource from = query.getFrom();


        SQLExpr where = query.getWhere();
        if (where != null) {
            while (where != null) {
                SQLBinaryOpExpr expr = (SQLBinaryOpExpr) where;
                SQLExpr right = expr.getRight();
                SQLExpr left = expr.getLeft();
                if (right instanceof SQLPropertyExpr && left instanceof SQLPropertyExpr) {
                    break;
                }
                if (left instanceof SQLCharExpr || left instanceof SQLIntegerExpr
                        || right instanceof SQLCharExpr || right instanceof SQLIntegerExpr) {
                    String ownernName = "";
                    if (left instanceof SQLPropertyExpr) {
                        ownernName = ((SQLPropertyExpr) left).getOwnernName();
                    } else {
                        ownernName = ((SQLPropertyExpr) right).getOwnernName();
                    }
                    String res = expr.toString();
                    System.out.println("ownernName：" + ownernName + "---->,res:" + res);
                    where = null;
                } else {
                    where = getSQLExpr(0, expr, right);
                    if (null == where) {
                        where = getSQLExpr(1, expr, left);
                        if (null == where) {
                            where = expr.getLeft();
                        }
                    }
                }
            }
        }

        SQLOrderBy orderBy = query.getOrderBy();
        if (orderBy != null) {
            for (SQLSelectOrderByItem orderByItem : orderBy.getItems()) {
                if (orderByItem.getExpr() instanceof SQLPropertyExpr) {
                    SQLPropertyExpr propertyExpr = (SQLPropertyExpr) orderByItem.getExpr();
                    //表名
                    String table = propertyExpr.getOwner().toString();
                    //列名
                    String name = propertyExpr.getName();
                    result.addOrderColumn(table, name);
                }
            }
        }

        for (SQLSelectItem column : query.getSelectList()) {

            if (column.getExpr() instanceof SQLAllColumnExpr) {
                result.setSelectAll(true);
                return result;
            }

            QueryResult selectResult = new QueryResult();
            if (column.getExpr() instanceof SQLPropertyExpr) {
                result.addSelectResult(selectResult);

                if (StringUtils.isEmpty(column.getAlias())) {
                    selectResult.setColumnAlias(column.toString());
                } else {
                    selectResult.setColumnAlias(column.getAlias());
                }
                processSqlPropertyExpr(column.getExpr(), result, selectResult);
            }

            if (column.getExpr() instanceof SQLAggregateExpr) {
                result.addSelectResult(selectResult);
                SQLAggregateExpr expr = (SQLAggregateExpr) column.getExpr();

                if (StringUtils.isEmpty(column.getAlias())) {
                    selectResult.setColumnAlias(column.toString());
                } else {
                    selectResult.setColumnAlias(column.getAlias());
                }

                selectResult.setMethod(expr.getMethodName());

                //TODO
                SQLExpr sqlExpr = expr.getArguments().get(0);
                selectResult.setSql(sqlExpr.toString());

                if (sqlExpr instanceof SQLPropertyExpr) {
                    processSqlPropertyExpr(sqlExpr, result, selectResult);
                }

                if (sqlExpr instanceof SQLBinaryOpExpr) {
                    processSqlBinaryOpExpr(sqlExpr, result, selectResult);
                }
            }
        }

        return result;
    }

    @Data
    @AllArgsConstructor
    public static class WhereFilter {
        private String op;
        private String name;
    }

    public String processWhere(QuerySchema querySchema, SQLExpr left, SQLExpr right, String operator) {

        String leftWhere = null;
        String rightWhere = null;
        if (left instanceof SQLBinaryOpExpr) {
            SQLBinaryOpExpr expr = (SQLBinaryOpExpr) left;
            leftWhere = processWhere(querySchema, expr.getLeft(), expr.getRight(), expr.getOperator().name);
        }
        if (right instanceof SQLBinaryOpExpr) {
            SQLBinaryOpExpr expr = (SQLBinaryOpExpr) right;
            rightWhere = processWhere(querySchema, expr.getLeft(), expr.getRight(), expr.getOperator().name);
        }


        if (left instanceof SQLPropertyExpr) {
            SQLPropertyExpr expr = (SQLPropertyExpr) left;
            if (!(right instanceof SQLBinaryOpExpr || right instanceof SQLPropertyExpr)) {

                querySchema.addWhere(expr.getOwner().toString(), expr.getName() + operator + right.toString());
                return expr.getOwner().toString();
            }
        }

        if (right instanceof SQLPropertyExpr) {
            SQLPropertyExpr expr = (SQLPropertyExpr) right;
            if (!(left instanceof SQLBinaryOpExpr || left instanceof SQLPropertyExpr)) {
                querySchema.addWhere(expr.getOwner().toString(), left.toString() + operator + expr.getName());
                return expr.getOwner().toString();
            }
        }

        return StringUtils.isEmpty(leftWhere) ? rightWhere : leftWhere;
    }

    /**
     * 收集sql信息
     *
     * @param sqlExpr
     * @param selectColumn
     * @param result
     */
    private void processSqlBinaryOpExpr(SQLExpr sqlExpr, QuerySchema selectColumn, QueryResult result) {
        if (sqlExpr instanceof SQLBinaryOpExpr) {
            result.setBinaryOperator(true);
            SQLBinaryOpExpr sqlBinaryExpr = (SQLBinaryOpExpr) sqlExpr;
            SQLExpr left = sqlBinaryExpr.getLeft();
            SQLExpr right = sqlBinaryExpr.getRight();
            processSqlBinaryOpExpr(left, selectColumn, result);
            processSqlBinaryOpExpr(right, selectColumn, result);
        }
        processSqlPropertyExpr(sqlExpr, selectColumn, result);
    }

    /**
     * 收集sql信息
     *
     * @param sqlExpr
     * @param selectColumn
     * @param queryResult
     */
    private void processSqlPropertyExpr(SQLExpr sqlExpr, QuerySchema selectColumn, QueryResult queryResult) {
        if (sqlExpr instanceof SQLPropertyExpr) {
            SQLPropertyExpr propertyExpr = (SQLPropertyExpr) sqlExpr;
            //表名
            String table = propertyExpr.getOwner().toString();
            //列名
            String name = propertyExpr.getName();

            if (queryResult != null) {
                if (queryResult.isMethodColumn()) {
                    queryResult.addExpirParam(propertyExpr.toString(), table, name);
                } else {
                    queryResult.setTableAlias(table);
                    queryResult.setColumn(name);
                }
            }
            selectColumn.addAliasColumn(table, name);
            if ("*".equals(name)) {
                queryResult.setQueryAll(true);
            }
        }
    }


    /**
     * 表名->别名
     *
     * @param selectStatement
     * @return
     */
    public Map<String, String> aliasMap(SQLSelectStatement selectStatement) {
        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        selectStatement.accept(visitor);
        // 表 别名
        MysqlAliasVisitor mysqlAliasVisitor = new MysqlAliasVisitor();
        selectStatement.accept(mysqlAliasVisitor);

        return mysqlAliasVisitor.getAliasMap();
    }

    /**
     * 别名->物理表名
     *
     * @param aliasMap
     * @return
     */
    public Map<String, String> tableAliasMap(Map<String, String> aliasMap) {
        Map<String, String> map = new HashMap<>();
        Set<Map.Entry<String, String>> entries = aliasMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            map.put(entry.getValue(), entry.getKey());
        }
        return map;
    }

    public static class MysqlAliasVisitor extends MySqlASTVisitorAdapter {

        private final Set<TableAlias> tableAliasSet = new HashSet<>();

        @Override
        public boolean visit(SQLExprTableSource x) {
            Objects.requireNonNull(x);
            tableAliasSet.add(new TableAlias(x.toString(), x.getAlias()));
            return true;
        }

        /**
         * key: tableName value: tableAlias
         */
        public Map<String, String> getAliasMap() {
            return tableAliasSet.stream().collect(HashMap::new, (m, v) ->
                            m.put(v.getTableName(), StringUtils.isEmpty(v.getAlias()) ? v.getTableName() :
                                    v.getAlias()),
                    HashMap::putAll);
        }

        public Set<TableAlias> getTableAliasSet() {
            return tableAliasSet;
        }

        @Data
        @AllArgsConstructor
        public static class TableAlias implements Serializable {
            private String tableName;
            private String alias;
        }
    }

}
