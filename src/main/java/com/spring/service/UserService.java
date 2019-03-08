package com.spring.service;

import com.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserDao userDao;



    public String getUserName(String id){
        return userDao.getUserById(id).getName();
    }


    @Required
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
