package com.spring;

public class TimeTest
{


    public static void main(String[] args) {



        String s = "abcdefg";

        long l = System.currentTimeMillis();
        for (int i  =0 ;i<50000000;i++){

           // int s2 = s.indexOf('g');



        }
        System.out.println(System.currentTimeMillis()-l);

    }
}
