package com.miteng.strive.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class HelloController {
    HelloController() {
        System.out.println("初始化方法...");
    }

    private static String path = "";

    static {
        path = PathUtil.getPath();
    }
}
