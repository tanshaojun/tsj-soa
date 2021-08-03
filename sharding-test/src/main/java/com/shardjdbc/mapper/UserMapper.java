package com.shardjdbc.mapper;

import com.shardjdbc.entity.User;

/**
 * @Author tansj
 * @Date 2021/8/2 下午2:40
 * @Version 1.0
 */
public interface UserMapper {
    /**
     * 保存
     */
    void save(User user);

    /**
     * 查询
     * @param id
     * @return
     */
    User get(Long id);

}
