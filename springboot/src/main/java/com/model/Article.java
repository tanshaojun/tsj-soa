package com.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    /**
     * 标题
     */
    @Column(name = "title", unique = true, nullable = false)
    private String title;
    /**
     * 较少的内容
     */
    @Column(name = "titsmallcontentle", unique = true, nullable = false)
    private String smallcontent;
    /**
     * 内容
     */
    @Column(name = "content", unique = true, nullable = false)
    private String content;
    /**
     * 作者
     */
    @Column(name = "author", unique = true, nullable = false)
    private String author;
    /**
     * 分类
     */
    @Column(name = "type", unique = true, nullable = false)
    private String type;
    /**
     * 浏览
     */
    @Column(name = "browse", unique = true, nullable = false)
    private Integer browse;
    /**
     * 是否显示
     */
    @Column(name = "isshow", unique = true, nullable = false)
    private Integer isshow;
    /**
     * 图片地址
     */
    @Column(name = "imgurl", unique = true, nullable = false)
    private String imgurl;
    /**
     * 创建时间
     */
    @Column(name = "created", unique = true, nullable = false)
    private Date created;
    /**
     * 修改时间
     */
    @Column(name = "modified", unique = true, nullable = false)
    private Date modified;
}
