package com.spring;

import com.spring.dao.UserDao;
import com.spring.domain.User;
import com.spring.proxy.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTest {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/data/dao.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        User user = userDao.getUserByid2(4291);
        System.out.println(user.getName()+"--"+user.getId());
    }
}
