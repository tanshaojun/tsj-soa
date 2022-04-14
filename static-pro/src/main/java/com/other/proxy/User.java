package com.other.proxy;

import lombok.Data;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/15 9:43
 */
@Data
public class User {
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
