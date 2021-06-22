package com.miteng.strive;

import com.miteng.strive.pojo.Money;
import com.miteng.strive.util.SpringContextHolder;
import org.junit.jupiter.api.Test;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


@SpringBootTest
@Rollback(false)
class StriveApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    TransactionTemplate txTemplate;

    @Test
    public void contextLoads() {
        txTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                int update = jdbcTemplate.update("update money set params = '分三碗饭' where id=1");
                System.out.println("修改结果:" +update);
                int update1 = jdbcTemplate.update("update user0 set name = '水电费' where id = 1");
                System.out.println("修改接口2:" +update1);
            }
        });
    }

    @Test
    public void test2() {
        Money bean = SpringContextHolder.getBean(Money.class);
        System.out.println(bean);
    }


}
