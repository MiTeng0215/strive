package com.miteng.strive.aop;

public class Client {


    private Calculator calculator;
    // 给calculator做一个切面类,实现日志的切入记

    public void test() {
//        System.out.println(calculator.getClass());
        System.out.println(calculator.add(1,2));
    }
}
