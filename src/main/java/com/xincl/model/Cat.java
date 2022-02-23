package com.xincl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Cat {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name",nullable = true,length = 20)
    private String name;

    @Column(name = "age",nullable = true,length = 4)
    private int age;

    @Column(name = "color",nullable = true,length = 20)
    private String color;
}
