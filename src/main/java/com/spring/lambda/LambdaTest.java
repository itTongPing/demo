package com.spring.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {


    public static void main(String[] args) {
        new Thread(()-> {System.out.println("123");}).start();


        Lamb lamb = (int x,int y)-> {return x+y;};
        System.out.println(lamb.add(2, 5));
        System.out.println(lamb.getValue());



        List<String> languages = Arrays.asList("java","scala","python");
        //before java8
        for(String each:languages) {
            System.out.println(each);
        }
        //after java8
        languages.forEach((String x) -> System.out.println(x));
        languages.forEach((String x) -> Print.printConente(x));
        Print print = new Print();
        languages.forEach(print::method);
        languages.forEach(System.out::println);


    }


    @Test
    public void mapTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        cost.stream().map(x -> x + x*0.05).forEach(x -> System.out.println(x));
        cost.stream().map(Print::insNumber).forEach(x -> System.out.println(x));
    }

    @Test
    public void mapTest2() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        Double aDouble = cost.stream().reduce((sum, x) ->  sum+x).get();
        System.out.println(aDouble);
    }

    @Test
    public void mapTest3() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);

        Stream<Double> doubleStream = cost.stream().filter(x -> x > 25);
        List<Double> collect = doubleStream.collect(Collectors.toList());
        collect.forEach(System.out::println);


    }



}
