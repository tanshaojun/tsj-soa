package com.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    /**
     * 自关联id
     */
    @Column(name = "pid")
    private Integer pid;
    /**
     * 评论
     */
    @Column(name = "comment")
    private String comment;
    /**
     * 日志ID
     */
    @Column(name = "logid")
    private Integer logid;
    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createTime;
}
