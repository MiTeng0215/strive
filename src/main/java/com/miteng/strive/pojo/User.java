package com.miteng.strive.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author 苗腾
 * @Date 2021/6/22 17:29
 * @Version 1.0
 */
@Component
@Data
public class User {
    private Integer id;
    private String name;
}
