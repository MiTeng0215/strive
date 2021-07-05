package com.miteng.strive.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Administrator
 */
@Component
public class TxService {

    private final JdbcTemplate jdbcTemplate;

    public TxService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void test1() throws FileNotFoundException {
        int update = jdbcTemplate.update("update money set type = 13 where id = 1");
        System.out.println("执行结果1:"+update);
        int update1 = jdbcTemplate.update("update user0 set age = 20000 where id = 1");
        System.out.println("执行结果2:" +update1);
        // 编译时异常
//        new FileInputStream("D:sdfsad");
    }
}
