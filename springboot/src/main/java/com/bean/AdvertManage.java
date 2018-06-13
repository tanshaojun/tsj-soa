package com.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class AdvertManage implements Serializable {

    private static final long serialVersionUID = 18454512128451L;
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
     * 内容
     */
    @Column(name = "content")
    private String content;
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
