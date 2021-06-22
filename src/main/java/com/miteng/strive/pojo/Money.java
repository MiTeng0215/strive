package com.miteng.strive.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author 苗腾
 * @Date 2021/6/21 19:56
 * @Version 1.0
 */
@Data
@Component
public class Money {
    private Integer id;
    private String params;
    private Integer isDefault;
    private Integer type;

    public Money() {
        System.out.println("创建money对象");
        id = 1;
        params = "sda";
        isDefault = 1;
        type = 2;
    }
}
