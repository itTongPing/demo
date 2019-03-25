package com.spring.lambda;


@FunctionalInterface
public  interface  Lamb {



     int add(int x,int y);

     default String getValue(){return "method of interface";}




}
