package com.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "price", unique = true, nullable = false)
    private String price;
    @Column(name = "mode", unique = true, nullable = false)
    private String mode;
    @Column(name = "direction", unique = true, nullable = false)
    private String direction;
    @Column(name = "huxing", unique = true, nullable = false)
    private String huxing;
    @Column(name = "floor", unique = true, nullable = false)
    private String floor;
    @Column(name = "area", unique = true, nullable = false)
    private String area;
    @Column(name = "renovation", unique = true, nullable = false)
    private String renovation;
    @Column(name = "address", unique = true, nullable = false)
    private String address;
    @Column(name = "phone", unique = true, nullable = false)
    private String phone;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "subway", unique = true, nullable = false)
    private String subway;
    @Column(name = "info", unique = true, nullable = false)
    private String info;
    @Column(name = "housing", unique = true, nullable = false)
    private String housing;
    @Column(name = "t", unique = true, nullable = false)
    private String t;
    @Column(name = "idkey", unique = true, nullable = false)
    private String idkey;
    @Column(name = "created", unique = true, nullable = false)
    private Date created;
    @Column(name = "modifyed", unique = true, nullable = false)
    private Date modifyed;
}
