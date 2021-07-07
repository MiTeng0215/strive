package com.miteng.strive;

import com.miteng.strive.dao.PersonMapper;
import com.miteng.strive.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
@Rollback(false)
public class MybatisTest {
    @Test
    public void testPerson() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            Person person = mapper.findPersonById(1);
            System.out.println(person);
        }
    }

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void updateTest() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            int i = mapper.updatePerson("苗腾", 24, 1);
            session.commit();
            System.out.println(i);
        }
    }

    @Test
    public void deletePerson() {

    }

    @Test
    public void addPerson() {
        // true:自动提交
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            int i = mapper.addPerson(new Person("zz", 18));
            System.out.println(i);
        }
    }
}
