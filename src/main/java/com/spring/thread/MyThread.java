package com.spring.thread;

public class MyThread extends Thread {

    @Override
    public void run() {
        long beginTime=System.currentTimeMillis();
        Long count = Long.valueOf(0);
        for (int i = 0; i < 50000000; i++) {

            count =Long.valueOf(i);
           // System.out.println("count" +count);
            yield();
            //System.out.println("count" +count);


        }
        long endTime=System.currentTimeMillis();
        System.out.println("用时："+(endTime-beginTime)+" 毫秒！");

    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();

        t.start();


        MyThread02 thread02 = new MyThread02();
        thread02.start();
        MyThread02 thread03 = new MyThread02();
        thread03.start();
        MyThread02 thread04 = new MyThread02();
        thread04.start();
        MyThread02 thread05 = new MyThread02();
        thread05.start();




    }
}
