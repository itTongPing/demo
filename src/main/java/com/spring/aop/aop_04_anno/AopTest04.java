package com.spring.aop.aop_04_anno;

import com.spring.proxy.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest04 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/aopApplication04.xml");

        UserService userService = (UserService) context.getBean("userService");

        userService.show("aa");
    }
}
