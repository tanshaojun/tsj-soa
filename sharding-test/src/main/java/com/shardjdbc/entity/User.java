package com.shardjdbc.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author tansj
 * @Date 2021/8/2 下午2:37
 * @Version 1.0
 */
@Data
public class User {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private Integer cityId;
    private Date createTime;
    private Integer sex;
}
