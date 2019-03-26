package com.spring.thread.thread01;

public class Consumer extends Thread{

    private final Shared s;


    Consumer(Shared s){
        this.s = s;
    }


    @Override
    public void run() {
        char ch;
        do{
             ch = s.getChar();
            System.out.println(ch+"-->is consumer by consumer");

        }while(ch<='Z');



    }



}
