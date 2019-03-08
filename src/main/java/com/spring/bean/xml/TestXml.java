package com.spring.bean.xml;

import com.spring.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXml {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("daos.xml");
        UserDao bean = context.getBean(UserDao.class);
        System.out.println("args = [" + bean.getUserById("1").getName() + "]");



    }

}
