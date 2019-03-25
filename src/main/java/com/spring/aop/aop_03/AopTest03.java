package com.spring.aop.aop_03;

import com.spring.proxy.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest03
{

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/aopApplication03.xml");

        UserService userService = (UserService) context.getBean("userService");

        userService.show("aa");
    }
}
