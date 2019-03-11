package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {


    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("userAop.xml");

        AopUser u = (AopUser) context.getBean("aopUser");
        String name = u.getName("1");

        System.out.println(name);

    }
}
