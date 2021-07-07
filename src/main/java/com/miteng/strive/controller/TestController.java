package com.miteng.strive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("hello1")
    public void request() {
        System.out.println("hello 123");
    }
}
