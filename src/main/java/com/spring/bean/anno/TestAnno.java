package com.spring.bean.anno;

import com.spring.dao.UserDao;
import com.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        UserService userService = (UserService) context.getBean("userService");

        System.out.print(userService.getUserDao().getUser());



    }

}
