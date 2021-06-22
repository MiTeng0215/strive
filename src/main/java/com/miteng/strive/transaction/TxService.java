package com.miteng.strive.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Component
public class TxService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void test1() throws FileNotFoundException {
        int update = jdbcTemplate.update("update person set age = 13 where id = 1");
        System.out.println("执行结果1:"+update);
        int update1 = jdbcTemplate.update("update deposit set deposit = 20000 where id = 1");
        System.out.println("执行结果2:" +update1);
        // 编译时异常
        new FileInputStream("D:sdfsad");
    }
}
