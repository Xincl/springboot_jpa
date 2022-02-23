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
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "pname",nullable = true,length = 30)
    private String pname;

    @Column(name = "pversion",nullable = true,length = 20)
    private String pversion;

    @Column(name = "pid",nullable = true,length = 50)
    private Long personId;

}
