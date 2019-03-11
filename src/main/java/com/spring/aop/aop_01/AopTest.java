package com.spring.aop.aop_01;

import com.spring.proxy.UserService;
import com.spring.proxy.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/aopApplication.xml");

        UserService proxyId = (UserService) context.getBean("proxyId");
        proxyId.show("a");


    }
}
