package com.littleevil.mybatisdemo.entity;

import lombok.Data;

@Data
public class House {

    private int id;
    private String name;
    private Integer master;

    public House() {
    }
}
