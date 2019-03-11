package com.spring.proxy;

public class UserServiceImpl implements UserService{


    private String str = "aaa";


    public void show(String str) {
        System.out.println("jdk----代理");
    }



    public void  cglibMethod(){
            System.out.println("cglib---代理");
    }

}
