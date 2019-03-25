package com.spring.thread;

public class Test {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable(){
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
    }


}
