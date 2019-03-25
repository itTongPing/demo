package com.spring.thread;

public class ThreadState {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName()+"state"+Thread.currentThread().getState());

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
            }
        };
    Thread t = new Thread(r);
        System.out.println(t.getState());
        t.start();
        try {
            Thread.sleep(4000);
            System.out.println(t.getState());

            Thread.sleep(1200);
        } catch (InterruptedException e) {

        }

        System.out.println(t.getState());



    }



}


