package com.spring.thread.thread01;

public class Shared {


    private char c;


    private volatile boolean writerable = true;




    synchronized void setChar(char c){

        if(!writerable){
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        this.c = c;
        writerable = false;
        notify();
    }



    synchronized char getChar(){
        if(writerable){
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }

        writerable = true;
        notify();
        return c;

    }


}
