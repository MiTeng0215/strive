package com.miteng.strive.ServletDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorld {

    @ResponseBody
    @RequestMapping("hello")
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("miao", "teng");
        response.addCookie(cookie);
        return "Hello world";
    }

    @ResponseBody
    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("请求收到了");
        Cookie cookie = new Cookie("miao", "teng");
        response.addCookie(cookie);
        System.out.println("目标方法执行了");
        return "请先登录";
    }
}
