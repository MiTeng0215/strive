package com.miteng.strive.pojo;

import lombok.Data;

/**
 * @Author 苗腾
 * @Date 2021/6/24 19:08
 * @Version 1.0
 */
@Data
public class Person {

    private Integer id;

    private String name;

    private Integer age;

    public Person(String zz, int i) {
        this.name = zz;
        this.age = i;
    }
}
