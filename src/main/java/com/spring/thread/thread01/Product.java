package com.spring.thread.thread01;

public class Product extends Thread{

    private final Shared s;


    Product(Shared s){
        this.s = s;
    }


    @Override
    public void run() {
        for(char ch='A';ch<='Z';ch++){

            s.setChar(ch);
            System.out.println(ch+"--->is product by producter");

        }



    }
}
