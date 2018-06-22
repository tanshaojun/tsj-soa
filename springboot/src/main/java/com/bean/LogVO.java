package com.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class LogVO implements Serializable {
    private static final long serialVersionUID = 1845128451L;

    private Integer id;
    /**
     * 标题
     */
    private String title;

    /**
     * 阅读量
     */
    private Integer readingvolume;

    /**
     * 内容
     */
    private String content;

    /**
     * 文章分类
     */
    private Integer type;

    /**
     * 关键字
     */
    private String crux;

    /**
     * 图片url
     */
    private String imgurl;

    /**
     * 作者
     */
    private String author;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */

    private Date modified;
    /**
     * value值
     */
    private String value;

}
