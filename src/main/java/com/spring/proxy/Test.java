package com.spring.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws Exception {


       /* UserServiceImpl userService = UserServiceImpl.class.newInstance();


        userService.show("1");

        Method method = UserServiceImpl.class.getMethod("show", String.class);
        Class<UserServiceImpl> clazz = UserServiceImpl.class;
        Field field = clazz.getDeclaredField("str");
        field.setAccessible(true);
        Object o = field.get(userService);
        System.out.println("o--字段----->"+o);
        Object invoke = method.invoke(userService, "1");
        System.out.println(invoke);*/


       Map<String,String> map = new HashMap<String, String>();

       map.put("aa", "haha");
       map.put("bb","hehe");
       System.out.println(map.toString());




    }



}
