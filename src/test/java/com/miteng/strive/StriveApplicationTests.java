package com.miteng.strive;

import com.miteng.strive.pojo.Money;
import com.miteng.strive.pojo.Person;
import com.miteng.strive.transaction.TxService;
import com.miteng.strive.util.SpringContextHolder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.yaml.snakeyaml.Yaml;


import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;


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
    @Autowired
    private TxService txService;

    @Test
    public void transaction() throws FileNotFoundException {
        txService.test1();
    }


//    @Test
//    public void king() throws SQLException {
//        DriverManager.registerDriver(new com.kingbase8.Driver());
//        Connection connection = DriverManager.getConnection
//                ("jdbc:kingbase8://localhost:54321/demo?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8",
//                        "SYSTEM",
//                        "521215");
//        Statement statement = connection.createStatement();
//        statement.execute("update person set age = 20 where id = 1");
//    }
//    @Autowired
//    private PersonDao personDao;
    @Test
    public void king2() {
//        List<Person> all = personDao.findAll();
//        System.out.println(all);
//        Person person = new Person();
//        person.setName("sqq");
//        person.setAge(18);
//        personDao.save(person);
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test1() {
        Object person = applicationContext.getBean("dd");
        System.out.println(person);
    }

   @Test
   public void test3() throws FileNotFoundException {
       InputStream input = Object.class.getResourceAsStream("classpath:application.yml");
       Yaml yaml = new Yaml();
       Map<String, Object> object = yaml.load(input);
       System.out.println(object);
   }

}
