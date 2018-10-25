package com.mapper;

import com.model.Article;
import com.model.Tag;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TagMapper extends Mapper<Tag> {

}
