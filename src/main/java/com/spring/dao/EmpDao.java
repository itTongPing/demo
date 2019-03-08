package com.spring.dao;

public class EmpDao {



    public String show(){
        return "test";
    }

    private void init() {
        System.out.println("init执行");
    }


    private void destory() {
        System.out.println("destory执行");
    }
}
