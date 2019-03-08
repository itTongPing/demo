package com.spring.bean.config;

import com.spring.dao.EmpDao;
import com.spring.javaConfig.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

public class ConfigTest {


    public static void main(String[] args) {



        /*AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        EmpDao empDao = (EmpDao) applicationContext.getBean("empDao");
        System.out.println("userDao = " + empDao);*/

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AppConfig.class);
        applicationContext.refresh();
        EmpDao empDao = (EmpDao) applicationContext.getBean("empDao");
        System.out.println("userDao = " + empDao);

        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println("args = [" + dataSource + "]");

        applicationContext.close();

    }
}
