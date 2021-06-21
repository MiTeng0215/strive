package com.miteng.strive.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Client {
    @Autowired
    private Calculator calculator;
    // 给calculator做一个切面类,实现日志的切入记录
    @Test
    public void test() {
//        System.out.println(calculator.getClass());
        System.out.println(calculator.add(1,2));
    }
}
