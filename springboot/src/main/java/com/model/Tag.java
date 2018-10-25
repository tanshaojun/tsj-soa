package com.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    /**
     * 标签名
     */
    @Column(name = "tagname", unique = true, nullable = false)
    private String tagname;

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
