package com.spring.javaConfig;

import com.spring.dao.EmpDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ImportResource("classpath:/daos.xml")
public class AppConfig {


    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;




    @Bean(initMethod = "init",destroyMethod = "destory")
    public EmpDao empDao(){
        return new EmpDao();
    }



    @Bean
    public DataSource dataSource(){
        return new DriverManagerDataSource(url, username, password);

    }










}
