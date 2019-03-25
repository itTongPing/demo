package com.spring.thread.thread01;

public class PC {


    public static void main(String[] args) {

        Shared s = new Shared();

        Product p  = new Product(s);
        Consumer c = new Consumer(s);

        p.start();
        c.start();

    }







}
