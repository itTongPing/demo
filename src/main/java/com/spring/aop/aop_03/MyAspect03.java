package com.spring.aop.aop_03;


import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect03 {




    public void myAround(ProceedingJoinPoint joinpoint) throws Throwable {

        System.out.println("前--3");
        joinpoint.proceed();
        System.out.println("后--3");

    }
}
