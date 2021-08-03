package com.shardjdbc.controller;

import com.shardjdbc.config.ShardingTableRuleActualTablesRefreshSchedule;
import com.shardjdbc.entity.User;
import com.shardjdbc.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * @Author tansj
 * @Date 2021/8/2 下午2:40
 * @Version 1.0
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private ShardingTableRuleActualTablesRefreshSchedule shardingTableRuleActualTablesRefreshSchedule;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user/save")
    public String save() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("test" + i);
            user.setCityId(1 % 2 == 0 ? 1 : 2);
            user.setCreateTime(new Date());
            user.setSex(i % 2 == 0 ? 1 : 2);
            user.setPhone("" + i);
            user.setEmail("" + i);
            user.setPassword("" + i);
            user.setCreateTime(new Date());
            userMapper.save(user);
        }
        return "success";
    }

    @RequestMapping("/user/get/{id}")
    public User get(@PathVariable Long id) {
        User user = userMapper.get(id);
        return user;
    }

    @RequestMapping("/user/test")
    public String test() {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            //创建表
            String sql = "CREATE TABLE  t_user_4 like t_user";
            statement.execute(sql);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            shardingTableRuleActualTablesRefreshSchedule.actualTablesRefresh(4);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "user";
    }

    @Autowired
    private DataSource dataSource;



}
