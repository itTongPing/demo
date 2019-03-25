package com.spring.aop.aop_01;

import com.spring.proxy.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest02 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/aopApplication02.xml");

       UserService userService = (UserService) context.getBean("userService");

       userService.show("aa");


    }
}
