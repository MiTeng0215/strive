package com.miteng.strive.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

/**
 * @Author 苗腾
 * @Date 2021/6/21 19:56
 * @Version 1.0
 */
@Data
public class Money {
    private Integer id;
    private String params;
    private Integer isDefault;
    private Integer type;

    public Money() {
        System.out.println("money 被创建了");
        id = 1;
        params = "sda";
        isDefault = 1;
        type = 2;
    }
}
