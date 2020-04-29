package com.other.t;

import com.github.pagehelper.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryResult {
    /**
     * 查询表别名
     */
    private String tableAlias;
    /**
     * 查询列
     */
    private String column;
    /**
     * 算子参数
     */
    private List<ColumnParam> exprParam;
    /**
     * 列函数
     */
    private String method;

    /**
     * 原始算子
     */
    private String sql;

    /**
     * 顺序存入需要替换的column
     */
    private List<String> replaceParam;
    //TODO
    /**
     * 查询列别名
     */
    private String columnAlias;

    /**
     * 存在算子计算
     */
    private boolean binaryOperator;

    /**
     * 是否查询全部列
     */
    private boolean queryAll;

    public void addExpirParam(String param, String alias, String column) {
        if (CollectionUtils.isEmpty(replaceParam)) {
            replaceParam = new ArrayList<>();
            exprParam = new ArrayList<>();
        }
        replaceParam.add(param);
        exprParam.add(new ColumnParam(alias, column));
    }


    public String getExpr() {
        int offSet = 0;
        String replaceSql = sql;
        StringBuilder stringBuilder = new StringBuilder(replaceSql);
        if (isMethodColumn() && !CollectionUtils.isEmpty(replaceParam)) {
            for (String param : replaceParam) {
                int indexOf = stringBuilder.indexOf(param);
                stringBuilder = stringBuilder.replace(indexOf, indexOf + param.length(), "$" + offSet++);
            }

        }
        return stringBuilder.toString();
    }

    /**
     * 是否函数方法
     *
     * @return
     */
    public boolean isMethodColumn() {
        return !StringUtil.isEmpty(method);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ColumnParam {
        /**
         * 查询的表别名
         */
        private String alias;
        /**
         * 查询列
         */
        private String column;
    }
}
