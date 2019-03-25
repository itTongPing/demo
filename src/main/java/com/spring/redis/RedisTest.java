package com.spring.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RedisTest {

    public static void main(String[] args) {


        //原生
        RedisClient redisClient = new RedisClient();

        //redisClient.show();


        //spring整合
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/redis/spring-redis.xml");
        RedisCacheManager cacheManager = (RedisCacheManager) context.getBean("redisCacheManager");
        cacheManager.set("url", "1234");
        Object url = cacheManager.get("url");
        System.out.println(url);


    }
}
