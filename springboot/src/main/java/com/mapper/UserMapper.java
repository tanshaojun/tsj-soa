package com.mapper;

import com.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getUser(@Param("id") Integer id);
}
