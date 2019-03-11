package com.spring.proxy;

public class MyAspect {


    public void pre(){
        System.out.println("前执行");
    }


    public void after(){
        System.out.println("后执行");
    }
}
