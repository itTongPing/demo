package com.spring.dao;

import com.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("userDao")
@Primary  //同种类型时,优先注入
public class UserDao {



    User user;

    @Autowired
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public User getUserById(String id){

        User u = new User();
        u.setId("1");
        u.setName("zhang");
        return u;
    }

}
