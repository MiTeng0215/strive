package com.miteng.strive.jdbcTemplate;

import com.miteng.strive.util.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 具名参数Jdbc, 通过:参数名 来进行sql传参
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void test() throws SQLException {
        DataSource bean = SpringContextHolder.getBean(DataSource.class);
        Connection connection = bean.getConnection();
        System.out.println(connection);
    }
}
