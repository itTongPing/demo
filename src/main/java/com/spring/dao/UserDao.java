package com.spring.dao;

import com.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("userDao")
//@Primary  //同种类型时,优先注入
public class UserDao  {

@Autowired
 private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
/* User user;

    @Autowired
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }*/

    public User getUserById(String id){

        User u = new User();
        u.setId("1");
        u.setName("zhang");
        return u;
    }


    public User getUserByid2(int id){

        String sql = "select id,lastname as name ,password from hrmresource where id = "+id;
        User user = (User) this.getJdbcTemplate().queryForObject(sql,new RowMapper(){
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                return user;
            }
        });
        return user;


    }












}
