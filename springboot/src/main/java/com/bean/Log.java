package com.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class Log implements Serializable {

    private static final long serialVersionUID = 1845128451L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 阅读量
     */
    @Column(name = "readingvolume")
    private Integer readingvolume;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 文章分类
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 关键字
     */
    @Column(name = "crux")
    private String crux;

    /**
     * 图片url
     */
    @Column(name = "imgurl")
    private String imgurl;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "modified")
    private Date modified;
}
