package com.spring.lambda;

public class Print {


    public static String  printConente(Object object){

        System.out.println(object.toString());
        return "123";

    }



    public void method(Object object){
        System.out.println(object+"----");
    }


    public static  double insNumber(double x){
     return  (x+x*0.05);
    }

}
