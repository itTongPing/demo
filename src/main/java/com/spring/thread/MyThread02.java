package com.spring.thread;

public class MyThread02 extends Thread{

    @Override
    public void run() {

        int count=0;
        for(int i  =0 ;i<5000000;i++){
           count=i;
        }


    }
}
