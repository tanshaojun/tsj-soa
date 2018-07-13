package com.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class Dir implements Serializable {

    private static final long serialVersionUID = 1845128451L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    /**
     * key
     */
    @Column(name = "key")
    private String key;

    /**
     * value
     */
    @Column(name = "value")
    private String value;
}
